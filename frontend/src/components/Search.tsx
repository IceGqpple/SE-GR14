import { useEffect, useMemo, useState } from "react";
import { hentStoppesteder, ReiseSok } from "../library/api";
import type { Reise } from "../types";

//Henter typene for stoppesteder og reiser
export default function Search() {
  const [stoppesteder, setStoppesteder] = useState<string[]>([]);
  const [from, setFrom] = useState("");
  const [to, setTo] = useState("");
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [results, setResults] = useState<Reise[]>([]);
  const [hasSearched, setHasSearched] = useState(false);

  //Henter stoppesteder fra API
  useEffect(() => {
    let isMounted = true;
    hentStoppesteder()
      .then((steder: string[]) => {
        if (isMounted) setStoppesteder(steder.filter(Boolean));
      })
      .catch((e) => setError(e?.message ?? "Klarte ikke hente stoppesteder"));
    return () => { isMounted = false; };
  }, []);

  //Valider at verdien finnes i lista – men lar det være frivillig
  function normalize(value: string) {
    return value.trim();
  }

  const canSearch = useMemo(() => {
    const a = normalize(from);
    const b = normalize(to);
    return a.length > 0 && b.length > 0 && a !== b;
  }, [from, to]);

  //Håndterer søk
  async function onSubmit(e: React.FormEvent) {
    e.preventDefault();
    if (!canSearch) return;
    setLoading(true);
    setError(null);
    setResults([]);
    setHasSearched(true);
    try {
      const data = await ReiseSok(normalize(from), normalize(to));
      const arr = Array.isArray(data) ? data : [data];
      setResults(arr as Reise[]);
    } catch (e: any) {
      setError(e?.message ?? "Noe gikk galt ved henting av reiser");
    } finally {
      setLoading(false);
    }
  }

  //Lar bruker swappe om fra og til
  function swap() {
    setFrom(to);
    setTo(from);
  }

  return (
    <div className="search">
      <h2>Hvor vil du reise?</h2>

      <form className="search_form" onSubmit={onSubmit}>
        <div className="field">
          <label htmlFor="from">Fra</label>
          <div className="field-wrapper">
            <input
              id="from"
              list="stoppesteder"
              placeholder="Sted eller adresse"
              value={from}
              onChange={(e) => setFrom(e.target.value)}/>
          </div>
        </div>

        <div className="swap-container">
          <button className="swap" type="button" onClick={swap} title="Bytt retning">↕</button>
        </div>

        <div className="field">
          <label htmlFor="to">Til</label>
          <div className="field-wrapper">
            <input
              id="to"
              list="stoppesteder"
              placeholder="Sted eller adresse"
              value={to}
              onChange={(e) => setTo(e.target.value)}/>
          </div>
        </div>

        <datalist id="stoppesteder">
          {stoppesteder.map((s) => (
            <option value={s} key={s} />
          ))}
        </datalist>
          {/*Søk knapp med loading state*/}
        <button className="btn" type="submit" disabled={!canSearch || loading}>
          {loading ? "Søker…" : "Søk"}
        </button>
      </form>
          {/*Sender feilmelding om det er en*/}
      {error && <p className="error">Feil: {error}</p>}

      {/*Favorittreiser seksjon*/}
      <section className="favorites">
        <h3>Mine favorittreiser</h3>
        <div className="favorite-item">
          <span className="star yellow">⭐</span>
          <span>Ingen reiser lagt til enda</span>
        </div>
        <div className="add-favorite" onClick={() => alert("Funksjonalitet kommer snart :)")}>
          <span className="star green">➕</span>
          <span>Legg til flere reiser</span>
        </div>
      </section>

      {/*Litt informasjon ofr søket*/}
      {hasSearched && (
        <section className="results" aria-live="polite">
          <h3>Forslag</h3>
          {loading && <p>Søker...</p>}
          {!loading && results.length > 0 && results.map((r, i) => <ReiseCard key={i} data={r} />)}
          {!loading && results.length === 0 && !error && <p>Ingen reiser funnet.</p>}
        </section>
      )}
    </div>
  );
}

//Viser reiser
function ReiseCard({ data }: { data: Reise }) {
  const ruter = (data.ruter ?? []) as any[];
  //Henter antall stopp
  const antall =
    (data.antallstop as number | undefined) ??
    (data.antallStopp as number | undefined) ??
    (data.antallStop as number | undefined);

  //Hent stoppesteder fra reisen, hvis tilgjengelig
  const reiseStoppesteder = data.stoppesteder ?? [];

  return (
    <article className="reise">
      <div className="reise_head">
        <strong>Reise</strong>
        {typeof antall === "number" && <span>{antall} stopp</span>}
      </div>
      {ruter.length > 0 ? (
        <ol className="reise_list">
          {ruter.map((r, idx) => {
            //Hent rutenavn
            const navn = r.name ?? r.navn ?? `Delreise ${idx + 1}`;
            
            //Hent kjøretøytype
            const kjøretøyType = r.kjøretøy?.type ?? r.kjoretoy?.type;
            
            /*Hente stoppesteder for denne delen av reisen:
            For reiser med en rute, vis alle stoppesteder fra reisen
            For reiser med flere ruter, må det deles opp basert på overganger*/
            let stops: string[] = [];
            
            if (ruter.length === 1) {
              //Enkel reise med en rute - vis alle stoppesteder fra reisen
              if (reiseStoppesteder.length > 0) {
                stops = reiseStoppesteder.map((s: any) => 
                  typeof s === 'string' ? s : (s.name ?? s.navn ?? '')
                ).filter(Boolean);
              }
            } else {
              //Reise med flere ruter - må dele opp stoppesteder basert på overganger
              const overganger = data.overganger ?? [];
              
              if (idx === 0) {
                //Første rute: fra start til første overgang (eller til slutt hvis ingen overganger)
                if (overganger.length > 0 && overganger[0]?.overgang) {
                  const overgangNavn = typeof overganger[0].overgang === 'string' 
                    ? overganger[0].overgang 
                    : (overganger[0].overgang?.name ?? overganger[0].overgang?.navn ?? '');
                  
                  //Finn alle stoppesteder frem til overgangen
                  let foundOvergang = false;
                  stops = reiseStoppesteder.map((s: any) => {
                    const navn = typeof s === 'string' ? s : (s.name ?? s.navn ?? '');
                    if (navn === overgangNavn) foundOvergang = true;
                    return foundOvergang ? null : navn;
                  }).filter(Boolean) as string[];
                  
                  //Legg til overgangen
                  if (overgangNavn) stops.push(overgangNavn);
                } else {
                  //Ingen overganger, vis alle stoppesteder
                  stops = reiseStoppesteder.map((s: any) => 
                    typeof s === 'string' ? s : (s.name ?? s.navn ?? '')
                  ).filter(Boolean);
                }
              } else {
                //Påfølgende ruter: fra forrige overgang til neste (eller til slutt)
                const prevOvergang = idx > 0 && overganger[idx - 1]?.overgang;
                const nextOvergang = idx < overganger.length && overganger[idx]?.overgang;
                
                let startIndex = 0;
                if (prevOvergang) {
                  const prevNavn = typeof prevOvergang === 'string' 
                    ? prevOvergang 
                    : (prevOvergang.name ?? prevOvergang.navn ?? '');
                  startIndex = reiseStoppesteder.findIndex((s: any) => {
                    const navn = typeof s === 'string' ? s : (s.name ?? s.navn ?? '');
                    return navn === prevNavn;
                  });
                  if (startIndex >= 0) startIndex += 1; //Start etter overgangen
                }
                
                let endIndex = reiseStoppesteder.length;
                if (nextOvergang) {
                  const nextNavn = typeof nextOvergang === 'string' 
                    ? nextOvergang 
                    : (nextOvergang.name ?? nextOvergang.navn ?? '');
                  endIndex = reiseStoppesteder.findIndex((s: any) => {
                    const navn = typeof s === 'string' ? s : (s.name ?? s.navn ?? '');
                    return navn === nextNavn;
                  });
                  if (endIndex < 0) endIndex = reiseStoppesteder.length;
                  else endIndex += 1; //Inkluder overgangen
                }
                
                stops = reiseStoppesteder.slice(startIndex, endIndex).map((s: any) => 
                  typeof s === 'string' ? s : (s.name ?? s.navn ?? '')
                ).filter(Boolean);
              }
            }
            
            //Fallback: hvis ingen stoppesteder funnet, prøver fra ruten selv
            if (stops.length === 0 && r.stoppeSteder && Array.isArray(r.stoppeSteder)) {
              stops = r.stoppeSteder.map((s: any) => 
                typeof s === 'string' ? s : (s.name ?? s.navn ?? '')
              ).filter(Boolean);
            }

            return (
              <li key={idx}>
                <div className="reise_legTitle">
                  {navn}
                  {kjøretøyType && <span className="reise_transport"> ({kjøretøyType})</span>}
                </div>
                {stops.length > 0 && (
                  <div className="reise_stops">{stops.join(" → ")}</div>
                )}
              </li>
            );
          })}
        </ol>
      ) : (
        <div>
          <p>Ingen rutedetaljer tilgjengelig.</p>
          <pre className="reise_raw">{JSON.stringify(data, null, 2)}</pre>
        </div>
      )}
      {data.overganger && Array.isArray(data.overganger) && data.overganger.length > 0 && (
        <div className="reise_overganger">
          <strong>Overganger:</strong> {data.overganger.length}
        </div>
      )}
    </article>
  );
}
