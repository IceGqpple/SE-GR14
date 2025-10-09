package model.app;

import model.core.StoppeSted;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        System.out.println("test");
        ArrayList<StoppeSted> mockStoppeSteder = new ArrayList<StoppeSted>();
        mockStoppeSteder.add(new StoppeSted("Fredrikstad"));
        System.out.println(mockStoppeSteder.getFirst().getName());
    }
}
