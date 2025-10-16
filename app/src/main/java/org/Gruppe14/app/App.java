package org.Gruppe14.app;

import org.Gruppe14.core.model.StoppSted;
import org.Gruppe14.core.model.Rute;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<StoppSted> stoppeStedList = new MockData().createMockStoppeSted();
        System.out.println("Stoppesteder: ");
        for(StoppSted stoppeSted : stoppeStedList){
            System.out.print(stoppeSted.getName() + ", ");
        }
        System.out.println("\n");
        ArrayList<Rute> ruteList = new MockData().createMockRute();

        System.out.println("Ruter: ");
        for(Rute rute : ruteList){
            System.out.print(rute.getName() + ": ");
            for(StoppSted stoppeSted : rute.getStoppeSteder()){
                System.out.print(stoppeSted.getName() + ", ");
            }
            System.out.println();
        }
    }
}