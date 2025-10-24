package domain;

import java.util.ArrayList;
import java.util.List;

public class Rute {
    private String name;
    private ArrayList<StoppeSted> stoppeSteder;
    private Kjøretøy kjøretøy;

    public Rute(String name, Kjøretøy kjøretøy, ArrayList<String> stoppested){
        this.name = name;
        this.kjøretøy = kjøretøy;
        ArrayList<StoppeSted> data = new ArrayList<StoppeSted>();
        for(String stopp : stoppested){
            data.add(new StoppeSted(stopp));
        }
        this.stoppeSteder = data;
    }

    public Rute(String name){
        this.name = name;
        stoppeSteder = new ArrayList<StoppeSted>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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