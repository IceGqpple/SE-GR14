package org.Gruppe14.core.model;

import java.util.ArrayList;
import java.util.List;

public class Rute {
    private String name;
    private ArrayList<StoppSted> stoppeSteder;
    private Vehicle vehicle;

    public Rute(String name, Vehicle vehicle, ArrayList<String> stoppested){
        this.name = name;
        this.vehicle = vehicle;
        ArrayList<StoppSted> data = new ArrayList<StoppSted>();
        for(String stopp : stoppested){
            data.add(new StoppSted(stopp));
        }
        this.stoppeSteder = data;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStoppeSteder(StoppSted sted){
        stoppeSteder.add(sted);
    }

    public void removeStoppeSted(StoppSted sted){
        stoppeSteder.remove(sted);
    }

    public List<StoppSted> getStoppeSteder(){
        return stoppeSteder;
    }

    public void setKjøretøy(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    public Vehicle getKjøretøy() {
        return vehicle;
    }
}