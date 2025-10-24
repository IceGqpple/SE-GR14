package domain;

import java.util.ArrayList;

public class ReiseSok {
    private StoppeSted startreise;
    private StoppeSted stopreise;
    private ArrayList<Reise> reiser;

    public ReiseSok(StoppeSted startreise, StoppeSted stopreise) {
        this.startreise = startreise;
        this.stopreise = stopreise;
        reiser = new ArrayList<Reise>();

        ArrayList<Rute> startReiseRute = new ArrayList<Rute>();
        ArrayList<Rute> ruteList = new MockData().getRuteList();
        for (Rute rute : ruteList) {
            boolean stopreise_not_first = true;
            for (StoppeSted stop : rute.getStoppeSteder()) {
                if(stop.getName().equals(stopreise.getName())){stopreise_not_first = false;}
                if (stop.getName().equals(startreise.getName()) && stopreise_not_first) {
                    startReiseRute.add(rute);
                }
            }
        }
        for(Rute rute : startReiseRute){
            ArrayList<StoppeSted> temp = new ArrayList<StoppeSted>();
            boolean start_add = false;
            for (StoppeSted stop : rute.getStoppeSteder()) {
                if (stop.getName().equals(startreise.getName())){start_add = true;}
                if(start_add){temp.add(stop);}
                if(stop.getName().equals(stopreise.getName())){
                    start_add = false;
                    reiser.add(new Reise(rute, temp, new ArrayList<Overgang>()));
                    startReiseRute.remove(rute);
                }
            }
        }



        for (Rute rute : startReiseRute) {
            System.out.println(rute.getName());
        }
    }
}