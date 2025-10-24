package domain;

public class Overgang {
    private StoppeSted overgang;
    private Rute ruteInn;
    private Rute ruteUt;

    public Overgang(StoppeSted overgang, Rute ruteInn, Rute ruteUt){
        this.overgang = overgang;
        this.ruteInn = ruteInn;
        this.ruteUt = ruteUt;
    }

    public Rute getRuteInn() {
        return ruteInn;
    }

    public Rute getRuteUt() {
        return ruteUt;
    }

    public StoppeSted getOvergang() {
        return overgang;
    }

    public void setOvergang(StoppeSted overgang) {
        this.overgang = overgang;
    }

    public void setRuteInn(Rute ruteInn) {
        this.ruteInn = ruteInn;
    }

    public void setRuteUt(Rute ruteUt) {
        this.ruteUt = ruteUt;
    }
}
