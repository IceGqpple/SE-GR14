package app;

import java.util.ArrayList;
import java.util.Arrays;

import domain.*;

public class MockData {
    public ArrayList<StoppeSted> createMockStoppeSted(){
        ArrayList<StoppeSted> data = new ArrayList<StoppeSted>();
        data.add(new StoppeSted("Moss"));
        data.add(new StoppeSted("Halden"));
        data.add(new StoppeSted("Sarpsborg"));
        data.add(new StoppeSted("Fredrikstad"));
        data.add(new StoppeSted("Rakkestad"));
        data.add(new StoppeSted("Kornsjø"));
        data.add(new StoppeSted("Rygge"));
        data.add(new StoppeSted("Remmen"));
        data.add(new StoppeSted("Greåker"));
        data.add(new StoppeSted("Østfoldhallen"));
        data.add(new StoppeSted("Borgenhaugen"));
        data.add(new StoppeSted("Rudsskogen"));
        data.add(new StoppeSted("Festningen"));
        data.add(new StoppeSted("Prestebakke"));
        data.add(new StoppeSted("Råde"));
        data.add(new StoppeSted("Svinesundparken"));
        data.add(new StoppeSted("Saltnes"));
        data.add(new StoppeSted("Ise"));
        data.add(new StoppeSted("Solli"));
        data.add(new StoppeSted("Viksletta"));
        data.add(new StoppeSted("Gressvik"));
        data.add(new StoppeSted("Kalnes"));
        data.add(new StoppeSted("Skjeberg"));
        data.add(new StoppeSted("Sandbakken"));
        data.add(new StoppeSted("Begby"));
        data.add(new StoppeSted("Skjærviken"));

        return data;
    }

    public ArrayList<Rute> createMockRute(){
        ArrayList<Rute> data = new ArrayList<Rute>();
        data.add(new Rute("Moss-Halden (Tog)", new Tog("Tog"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Råde", "Fredrikstad", "Sarpsborg", "Halden"))));
        data.add(new Rute("Halden-Moss (Tog)", new Tog("Tog"), new ArrayList<>(Arrays.asList("Halden", "Sarpsborg", "Fredrikstad", "Råde", "Rygge", "Moss"))));
        data.add(new Rute("Moss-Sarpsborg-Halden", new Buss("Buss"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Råde", "Solli", "Kalnes", "Sarpsborg", "Borgenhaugen", "Sandbakken", "Skjeberg", "Viksletta", "Svinesundsparken", "Renmmen", "Halden"))));
        data.add(new Rute("Halden-Sarpsborg-Moss", new Buss("Buss"), new ArrayList<>(Arrays.asList( "Halden", "Remmen", "Svinesundsparken", "Viksletta", "Skjeberg", "Sandbakken", "Borgenhaugen", "Sarpsborg", "Kalnes", "Solli", "Råde", "Rygge", "Moss"))));
        data.add(new Rute("Moss-Fredrikstad-Halden", new Buss("Buss"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Saltnes", "Gressvik", "Fredrikstad", "Begby", "Skjærviken", "Skjeberg", "Viksletta", "Svinesundsparken", "Remmen", "Halden"))));
        data.add(new Rute("Halden-Fredrikstad-Moss", new Buss("Buss"), new ArrayList<>(Arrays.asList("Halden", "Remmen", "Svinesundsparken", "Viksletta", "Skjeberg", "Skjærviken", "Begby", "Fredrikstad", "Gressvik", "Saltnes", "Rygge", "Moss"))));
        data.add(new Rute("Sarpsborg-Fredrikstad", new Buss("Buss"), new ArrayList<>(Arrays.asList("Sarpsborg", "Greåker", "Østfoldhallen", "Fredrikstad"))));
        data.add(new Rute("Fredrikstad-Sarpsborg", new Buss("Buss"), new ArrayList<>(Arrays.asList("Fredrikstad", "Østfoldhallen", "Greåker", "Sarpsborg"))));
        data.add(new Rute("Sarpsborg-Rakkestad", new Buss("Buss"), new ArrayList<>(Arrays.asList("Sarpsborg", "Borgenhaugen", "Ise", "Rudsskogen", "Rakkestad"))));
        data.add(new Rute("Rakkestad-Sarpsborg", new Buss("Buss"), new ArrayList<>(Arrays.asList("Rakkestad", "Rudsskogen", "Ise", "Borgenhaugen", "Sarpsborg"))));
        data.add(new Rute("Halden-Kornsjø", new Buss("Buss"), new ArrayList<>(Arrays.asList("Halden", "Festningen", "Bakke", "Prestebakke", "Kornsjø"))));
        data.add(new Rute("Kornsjø-Halden", new Buss("Buss"), new ArrayList<>(Arrays.asList("Kornsjø","Prestebakke", "Bakke", "Frestningen", "Halden"))));

        return data;
    }

}
