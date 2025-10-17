package model.app;

import model.core.model.Rute;
import model.core.model.StoppeSted;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<StoppeSted> stoppeStedList = new mockData().createMockStoppeSted();
        System.out.println("Stoppesteder: ");
        for(StoppeSted stoppeSted : stoppeStedList){
            System.out.print(stoppeSted.getName() + ", ");
        }
        System.out.println("\n");
        ArrayList<Rute> ruteList = new mockData().createMockRute();

        System.out.println("Ruter: ");
        for(Rute rute : ruteList){
            System.out.print(rute.getName() + ": ");
            for(StoppeSted stoppeSted : rute.getStoppeSteder()){
                System.out.print(stoppeSted.getName() + ", ");
            }
            System.out.println();
        }
    }
}
