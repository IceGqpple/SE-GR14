package runDB;

import adapter.RuteAdapter;
import adapter.StoppeStedAdapter;
import domain.Rute;
import domain.StoppeSted;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ///Test hente ut
         ArrayList<StoppeSted> stoppeStederv = StoppeStedAdapter.hentAlleStoppeSteder();
        System.out.println("\nStoppesteder\n");
         for(StoppeSted stoppeSted : stoppeStederv){
            System.out.println(stoppeSted.getName());
        }

        //Tester RuteAdapter. Ved å hente ut alle ruter i listen og alle stoppesteder på ruten
        System.out.println("\nRuter\n");
        ArrayList<Rute> ruter = RuteAdapter.hentAlleRuter();
        for(Rute rute : ruter){
            System.out.println(rute.getName());
            List<StoppeSted> stoppeSteder = rute.getStoppeSteder();
            for(StoppeSted stoppeSted : stoppeSteder){
                System.out.println("  " + stoppeSted.getName());
            }
        }



    }
}