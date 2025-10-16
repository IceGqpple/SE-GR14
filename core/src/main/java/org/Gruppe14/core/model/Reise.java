package org.Gruppe14.core.model;

import java.util.ArrayList;
import java.util.List;


public class Reise {
    private List<Rute> ruter;
    private StoppSted startSted;
    private StoppSted sluttSted;

    public Reise(StoppSted startSted, StoppSted sluttSted) {
        this.startSted = startSted;
        this.sluttSted = sluttSted;
        this.ruter = new ArrayList<>();
    }

    public void addRute(Rute rute) {
        ruter.add(rute);
    }

    public StoppSted getStartSted() {
        return startSted;
    }

    public void setStartSted(StoppSted startSted) {
        this.startSted = startSted;
    }

    public StoppSted getSluttSted() {
        return sluttSted;
    }

    public void setSluttSted(StoppSted sluttSted) {
        this.sluttSted = sluttSted;
    }

    public List<Rute> getRuter() {
        return ruter;
    }
}