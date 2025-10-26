package app;

import domain.MockData;
import domain.ReiseSok;
import domain.Rute;
import domain.StoppeSted;

import java.util.ArrayList;

public class App {
    // public variabler for alle stoppesteder og ruter
    //public static ArrayList<StoppeSted> stoppeStedList = new MockData().getStoppeSteder();
    //public static ArrayList<Rute> ruteList = new MockData().getRuteList();

    public static void main(String[] args) {

        ReiseSok test = new ReiseSok(new StoppeSted("Rakkestad"), new StoppeSted("Fredrikstad"));
    }
}

