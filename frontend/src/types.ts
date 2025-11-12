//Definerer av typer brukt
export type StoppeSted = string | {name?: string; navn?: string};

export type Kjøretøy = {
  type?: string;
};

export type Rute = {
  name?: string;
  navn?: string; //Fallback for kompatibilitet
  stoppeSteder?: StoppeSted[];
  stopp?: string[]; //Fallback
  stoppesteder?: string[]; //Fallback
  kjøretøy?: Kjøretøy;
};

export type Overgang = {
  overgang?: StoppeSted;
  ruteInn?: Rute;
  ruteUt?: Rute;
};

export type Reise = {
    ruter?: Rute[];
    stoppesteder?: StoppeSted[];
    overganger?: Overgang[];
    antallstop?: number;
    antallStop?: number;  //Hvis backend bruker dette
    antallStopp?: number; //eller dette
    [k: string]: unknown;
};
