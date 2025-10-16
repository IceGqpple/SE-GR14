package org.Gruppe14.app;

import org.Gruppe14.core.model.StoppSted;
import org.Gruppe14.core.model.Rute;
import org.Gruppe14.core.model.Buss;
import org.Gruppe14.core.model.Tog;

import java.util.ArrayList;
import java.util.Arrays;

public class MockData {
    public ArrayList<StoppSted> createMockStoppeSted(){
        ArrayList<StoppSted> data = new ArrayList<StoppSted>();
        data.add(new StoppSted("Moss"));
        data.add(new StoppSted("Halden"));
        data.add(new StoppSted("Sarpsborg"));
        data.add(new StoppSted("Fredrikstad"));
        data.add(new StoppSted("Rakkestad"));
        data.add(new StoppSted("Kornsjø"));
        data.add(new StoppSted("Rygge"));
        data.add(new StoppSted("Remmen"));
        data.add(new StoppSted("Greåker"));
        data.add(new StoppSted("Østfoldhallen"));
        data.add(new StoppSted("Borgenhaugen"));
        data.add(new StoppSted("Rudsskogen"));
        data.add(new StoppSted("Festningen"));
        data.add(new StoppSted("Prestebakke"));
        data.add(new StoppSted("Råde"));
        data.add(new StoppSted("Svinesundparken"));
        data.add(new StoppSted("Saltnes"));
        data.add(new StoppSted("Ise"));
        data.add(new StoppSted("Solli"));
        data.add(new StoppSted("Viksletta"));
        data.add(new StoppSted("Gressvik"));
        data.add(new StoppSted("Kalnes"));
        data.add(new StoppSted("Skjeberg"));
        data.add(new StoppSted("Sandbakken"));
        data.add(new StoppSted("Begby"));
        data.add(new StoppSted("Skjærviken"));

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