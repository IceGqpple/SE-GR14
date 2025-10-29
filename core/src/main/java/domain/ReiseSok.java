package domain;

import java.util.ArrayList;

public class ReiseSok {
    private StoppeSted startreise;
    private StoppeSted stoppreise;
    private ArrayList<Reise> reiser;

    public ReiseSok(StoppeSted startreise_input, StoppeSted stoppreise_input) {
        this.startreise = startreise_input;
        this.stoppreise = stoppreise_input;
        reiser = new ArrayList<Reise>();

        // Initialisering av variable for å hente inn ruteliste for rutesøk
        ArrayList<Rute> ruteList = new MockData().getRuteList();

        ArrayList<Rute> startReiseRute = new ArrayList<Rute>();
        ArrayList<Rute> stoppReiseRute = new ArrayList<Rute>();

        // logikk for å finne alle ruter som ikke holder startpunkt for reisen
        for (Rute rute : ruteList) {
            if(rute.finnStoppeSted(startreise.getName()) >= 0){
                startReiseRute.add(rute);
            }
        }

        // logikk for å finne og legge til reise som ikke krever overgang mellom ruter.
        for(Rute rute : startReiseRute){
            ArrayList<StoppeSted> temp = new ArrayList<StoppeSted>();
            if(rute.finnStoppeSted(stoppreise.getName()) > rute.finnStoppeSted(startreise.getName())){
                for (int i = rute.finnStoppeSted(startreise.getName()); i <= rute.finnStoppeSted(stoppreise.getName()); i++){
                    temp.add(rute.getStoppeSteder().get(i));
                }
                reiser.add(new Reise(rute, temp, new ArrayList<Overgang>()));
            }
        }
        if(reiser.isEmpty()){
            // logikk for å finne alle ruter som inneholder sluttpunkt for reisen.
            for (Rute rute : ruteList) {
                if(rute.finnStoppeSted(stoppreise.getName()) >= 0){
                    stoppReiseRute.add(rute);
                }
            }
            // logikk for å legge til reiser som en overgang mellom 2 ruter for å fullføre reisen.
            for(Rute startrute : startReiseRute){
                for(Rute stopprute : stoppReiseRute){
                    for(StoppeSted stop : startrute.getStoppeSteder() ){
                        if((stopprute.finnStoppeSted(stop.getName()) >= 0)){
                            if(startrute.finnStoppeSted(startreise.getName()) < startrute.finnStoppeSted(stop.getName())){
                                if(stopprute.finnStoppeSted(stoppreise.getName()) > stopprute.finnStoppeSted(stop.getName())) {
                                    ArrayList<StoppeSted> tempstopreise = new ArrayList<StoppeSted>();
                                    ArrayList<Overgang> tempoverganger = new ArrayList<Overgang>();
                                    tempoverganger.add(new Overgang(stop, startrute, stopprute));
                                    ArrayList<Rute> tempreiseruter = new ArrayList<Rute>();
                                    tempreiseruter.add(startrute);
                                    tempreiseruter.add(stopprute);
                                    for (int i = startrute.finnStoppeSted(startreise.getName()); i <= startrute.finnStoppeSted(stop.getName()); i++) {
                                        tempstopreise.add(startrute.getStoppeSteder().get(i));
                                    }
                                    for (int i = 1 + stopprute.finnStoppeSted(stop.getName()); i <= stopprute.finnStoppeSted(stoppreise.getName()); i++) {
                                        tempstopreise.add(stopprute.getStoppeSteder().get(i));
                                    }
                                    reiser.add(new Reise(tempreiseruter, tempstopreise, tempoverganger));
                                }
                            }
                        }
                    }
                }
            }
        }
        for (Reise reise : reiser){
            reise.printReise();
        }
    }
}