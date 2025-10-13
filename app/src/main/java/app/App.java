package app;

import domain.Rute;
import domain.StoppeSted;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<StoppeSted> stoppeStedList = new MockData().createMockStoppeSted();
        System.out.println("Stoppesteder: ");
        for(StoppeSted stoppeSted : stoppeStedList){
            System.out.print(stoppeSted.getName() + ", ");
        }
        System.out.println("\n");
        ArrayList<Rute> ruteList = new MockData().createMockRute();

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
