package Service;

import domain.Rute;
import exeption.RuteException;
import port.RuterPort;

import java.util.ArrayList;

public class RuteService {
    private final RuterPort ruterData;

    public RuteService(RuterPort ruterData){
        this.ruterData = ruterData;
    }

    public ArrayList<Rute> hentRuter(){
        try{
            return ruterData.hentAlleRuter();
        }
        catch (RuteException e){
            throw new RuntimeException("Kunne ikke hente ruter" + e.getMessage());
        }
    }

}
