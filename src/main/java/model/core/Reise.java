package model.core;

import java.util.ArrayList;
import java.util.List;


public class Reise {
    private List<Rute> ruter;
    private StoppeSted startSted;
    private StoppeSted sluttSted;

    public Reise(StoppeSted startSted, StoppeSted sluttSted) {
        this.startSted = startSted;
        this.sluttSted = sluttSted;
        this.ruter = new ArrayList<>();
    }

    public void addRute(Rute rute) {
        ruter.add(rute);
    }

    public StoppeSted getStartSted() {
        return startSted;
    }

    public void setStartSted(StoppeSted startSted) {
        this.startSted = startSted;
    }

    public StoppeSted getSluttSted() {
        return sluttSted;
    }

    public void setSluttSted(StoppeSted sluttSted) {
        this.sluttSted = sluttSted;
    }

    public List<Rute> getRuter() {
        return ruter;
    }
}
