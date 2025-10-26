package domain;

import java.util.ArrayList;

public class ReiseSok {
    private StoppeSted startreise;
    private StoppeSted stoppreise;
    private ArrayList<Reise> reiser;

    public ReiseSok(StoppeSted startreise, StoppeSted stopreise) {
        this.startreise = startreise;
        this.stoppreise = stopreise;
        reiser = new ArrayList<Reise>();

        ArrayList<Rute> startReiseRute = new ArrayList<Rute>();
        ArrayList<Rute> stoppReiseRute = new ArrayList<Rute>();
        ArrayList<Rute> test = new ArrayList<Rute>();
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

                }
            }
        }
        if(reiser.isEmpty()){
            for (Rute rute : ruteList) {
                if(rute.finnStoppeSted(stoppreise.getName()) >= 0){
                    stoppReiseRute.add(rute);
                }
            }
            for(Rute startrute : startReiseRute){
                for(Rute stopprute : stoppReiseRute){
                    for(StoppeSted stop : startrute.getStoppeSteder() ){
                        if((stopprute.finnStoppeSted(stop.getName()) >= 0)&& !(test.contains(stopprute))){
                            test.add(stopprute);
                        }


                        /*for(StoppeSted stopprutestopp : stopprute.getStoppeSteder()){
                            if(startrutestopp.getName().equals(stopprutestopp.getName()) && !(test.contains(stopprute))){
                                test.add(stopprute);
                            }
                        }*/
                    }
                }
            }
        }

        for (Rute rute : test) {
            System.out.println(rute.getName());
        }

        /*for (Reise reise : reiser){
            reise.printReise();
        }
        for (Rute rute : startReiseRute) {
            System.out.println(rute.getName());
        }
        for (Rute rute : stoppReiseRute) {
            System.out.println(rute.getName());
        }*/
    }
}