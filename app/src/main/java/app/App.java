package app;

import domain.MockData;
import domain.ReiseSok;
import domain.Rute;
import domain.StoppeSted;

import java.util.ArrayList;

public class App {
    // public variabler for alle stoppesteder og ruter
    public static ArrayList<StoppeSted> stoppeStedList = new MockData().getStoppeSteder();
    public static ArrayList<Rute> ruteList = new MockData().getRuteList();

    public static void main(String[] args) {
        /*
        System.out.println("Stoppesteder: ");
        for(StoppeSted stoppeSted : stoppeStedList){
            System.out.print(stoppeSted.getName() + ", ");
        }
        System.out.println("\n");

        System.out.println("Ruter: ");
        for(Rute rute : ruteList){
            System.out.print(rute.getName() + ": ");
            for(StoppeSted stoppeSted : rute.getStoppeSteder()){
                System.out.print(stoppeSted.getName() + ", ");
            }
            System.out.println();
       }*/
        ReiseSok test = new ReiseSok(new StoppeSted("Rakkestad"), new StoppeSted("Sarpsborg"));
    }
}
