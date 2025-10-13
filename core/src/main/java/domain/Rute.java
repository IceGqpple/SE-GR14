package domain;

import java.util.ArrayList;
import java.util.List;

public class Rute {

    private List<StoppeSted> stoppeSteder;
    private Kjøretøy kjøretøy;

    public Rute(Kjøretøy kjøretøy){
        this.kjøretøy = kjøretøy;
        this.stoppeSteder = new ArrayList<>();
    }

    public void addStoppeSteder(StoppeSted sted){
        stoppeSteder.add(sted);
    }

    public void removeStoppeSted(StoppeSted sted){
        stoppeSteder.remove(sted);
    }

    public List<StoppeSted> getStoppeSteder(){
        return stoppeSteder;
    }

    public void setKjøretøy(Kjøretøy kjøretøy){
        this.kjøretøy = kjøretøy;
    }

    public Kjøretøy getKjøretøy() {
        return kjøretøy;
    }
}
