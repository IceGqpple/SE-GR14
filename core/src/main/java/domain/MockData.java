package domain;

import java.util.ArrayList;
import java.util.Arrays;

// klasse for å lage mockdata til testing av appliksjonen.
public class MockData {
    private ArrayList<StoppeSted> stoppeSteder;
    private ArrayList<Rute> ruteList;

    public MockData(){
        stoppeSteder = new ArrayList<StoppeSted>();
        stoppeSteder.add(new StoppeSted("Moss"));
        stoppeSteder.add(new StoppeSted("Halden"));
        stoppeSteder.add(new StoppeSted("Sarpsborg"));
        stoppeSteder.add(new StoppeSted("Fredrikstad"));
        stoppeSteder.add(new StoppeSted("Rakkestad"));
        stoppeSteder.add(new StoppeSted("Rygge"));
        stoppeSteder.add(new StoppeSted("Remmen"));
        stoppeSteder.add(new StoppeSted("Greåker"));
        stoppeSteder.add(new StoppeSted("Østfoldhallen"));
        stoppeSteder.add(new StoppeSted("Borgenhaugen"));
        stoppeSteder.add(new StoppeSted("Rudsskogen"));
        stoppeSteder.add(new StoppeSted("Råde"));
        stoppeSteder.add(new StoppeSted("Svinesundparken"));
        stoppeSteder.add(new StoppeSted("Saltnes"));
        stoppeSteder.add(new StoppeSted("Ise"));
        stoppeSteder.add(new StoppeSted("Solli"));
        stoppeSteder.add(new StoppeSted("Viksletta"));
        stoppeSteder.add(new StoppeSted("Gressvik"));
        stoppeSteder.add(new StoppeSted("Kalnes"));
        stoppeSteder.add(new StoppeSted("Skjeberg"));
        stoppeSteder.add(new StoppeSted("Sandbakken"));
        stoppeSteder.add(new StoppeSted("Begby"));
        stoppeSteder.add(new StoppeSted("Skjærviken"));

        ruteList = new ArrayList<Rute>();
        ruteList.add(new Rute("Moss-Halden (Tog)", new Tog("Tog"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Råde", "Fredrikstad", "Sarpsborg", "Halden"))));
        ruteList.add(new Rute("Halden-Moss (Tog)", new Tog("Tog"), new ArrayList<>(Arrays.asList("Halden", "Sarpsborg", "Fredrikstad", "Råde", "Rygge", "Moss"))));
        ruteList.add(new Rute("Moss-Sarpsborg-Halden", new Buss("Buss"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Råde", "Solli", "Kalnes", "Sarpsborg", "Borgenhaugen", "Sandbakken", "Skjeberg", "Viksletta", "Svinesundsparken", "Renmmen", "Halden"))));
        ruteList.add(new Rute("Halden-Sarpsborg-Moss", new Buss("Buss"), new ArrayList<>(Arrays.asList( "Halden", "Remmen", "Svinesundsparken", "Viksletta", "Skjeberg", "Sandbakken", "Borgenhaugen", "Sarpsborg", "Kalnes", "Solli", "Råde", "Rygge", "Moss"))));
        ruteList.add(new Rute("Moss-Fredrikstad-Halden", new Buss("Buss"), new ArrayList<>(Arrays.asList("Moss", "Rygge", "Saltnes", "Gressvik", "Fredrikstad", "Begby", "Skjærviken", "Skjeberg", "Viksletta", "Svinesundsparken", "Remmen", "Halden"))));
        ruteList.add(new Rute("Halden-Fredrikstad-Moss", new Buss("Buss"), new ArrayList<>(Arrays.asList("Halden", "Remmen", "Svinesundsparken", "Viksletta", "Skjeberg", "Skjærviken", "Begby", "Fredrikstad", "Gressvik", "Saltnes", "Rygge", "Moss"))));
        ruteList.add(new Rute("Sarpsborg-Fredrikstad", new Buss("Buss"), new ArrayList<>(Arrays.asList("Sarpsborg", "Greåker", "Østfoldhallen", "Fredrikstad"))));
        ruteList.add(new Rute("Fredrikstad-Sarpsborg", new Buss("Buss"), new ArrayList<>(Arrays.asList("Fredrikstad", "Østfoldhallen", "Greåker", "Sarpsborg"))));
        ruteList.add(new Rute("Sarpsborg-Rakkestad", new Buss("Buss"), new ArrayList<>(Arrays.asList("Sarpsborg", "Borgenhaugen", "Ise", "Rudsskogen", "Rakkestad"))));
        ruteList.add(new Rute("Rakkestad-Sarpsborg", new Buss("Buss"), new ArrayList<>(Arrays.asList("Rakkestad", "Rudsskogen", "Ise", "Borgenhaugen", "Sarpsborg"))));
    }

    public ArrayList<Rute> getRuteList() {
        return ruteList;
    }

    public ArrayList<StoppeSted> getStoppeSteder() {
        return stoppeSteder;
    }
}
