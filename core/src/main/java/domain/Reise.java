package domain;

import java.util.ArrayList;
import java.util.List;


public class Reise {
    private ArrayList<Rute> ruter;
    private ArrayList<StoppeSted> stoppesteder;
    private ArrayList<Overgang> overganger;
    private int antallstop;

    public Reise(ArrayList<Rute> ruter, ArrayList<StoppeSted> stoppesteder, ArrayList<Overgang> overganger) {
        this.ruter = ruter;
        this.stoppesteder = stoppesteder;
        this.overganger = overganger;
        this.antallstop = stoppesteder.size();
    }

    public Reise(Rute rute, ArrayList<StoppeSted> stoppesteder, ArrayList<Overgang> overganger) {
        ruter = new ArrayList<Rute>();
        ruter.add(rute);
        this.stoppesteder = stoppesteder;
        this.overganger = overganger;
        this.antallstop = stoppesteder.size();
    }

    public ArrayList<Rute> getRuter() {
        return ruter;
    }
    public ArrayList<StoppeSted> getStoppesteder() {return stoppesteder;}

    public ArrayList<Overgang> getOverganger(){return overganger;}

    public void addRute(Rute rute){
        ruter.add(rute);
    }

    public void addStoppested(StoppeSted stoppeSted){
        stoppesteder.add(stoppeSted);
        antallstop = stoppesteder.size();
    }

    public void addOvergang(Overgang overgang){overganger.add(overgang);}

    public int getAntallstop() {return antallstop;}

    // hjelpe funksjon for å skrive ut reiser
    public void printReise(){
        System.out.print("Reise: " + stoppesteder.getFirst().getName() + " - " + stoppesteder.getLast().getName() + "\n");
        System.out.print("Ruter: ");
        for(Rute rute : ruter){
            System.out.print(rute.getName() + ", ");
        }
        System.out.print("\nStoppe steder: ");
        for(StoppeSted stop : stoppesteder){
            System.out.print(stop.getName() + ", ");
        }
        System.out.println();
        if(overganger.isEmpty()){
            System.out.println("Overgang: Ingen");
        } else {
            for(Overgang overgang : overganger){
                overgang.printOvergang();
                System.out.println();
            }
        }
        System.out.println("Antall stop: " + getAntallstop() + "\n");

    }




}
