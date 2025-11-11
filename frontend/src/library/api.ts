/*API klient for frontend til å kommunisere med backend 
vite-proxy sender alle kall som starter på "/api" til backend)*/
const base = "/api";

//Hjelpefunksjon (liten wrapper rundt fetch) for å hente JSON-data tilbake
async function GetJson<T>(url: string): Promise<T> {
const response = await fetch(url);
if (!response.ok) throw new Error(`HTTP error! status: ${response.status} - ${url}`);
return response.json() as Promise<T>;
}

//Hente stoppesteder i form av liste med strenger, eller objekter med "navn". Normaliseres som string
export async function hentStoppesteder(): Promise<string[]> {
    const data = await GetJson<any[]>(`${base}/stoppesteder`);

    /*Hvis første element er streng, cast og returner.
    Hvis første element er et objekt, map til sted.navn*/ 
    if (Array.isArray(data)) {
        if (typeof data[0] === "string") return data as string[];
        if (typeof data[0] === "object" && data[0] !== null) {
            return (data as Array<{ navn?: string}>).map((sted) => sted.navn ?? "");
        }
    }
    return [];
}

//Søk etter reiser mellom to stopp, bygger query string og hetner JSON fra /reisesok 
export async function ReiseSok(start: string, stopp: string) {
    const query = new URLSearchParams({ start, stopp }).toString();
    return GetJson<any[]>(`${base}/reisesok?${query}`);
}
