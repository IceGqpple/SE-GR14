package Service;

import domain.Rute;
import port.RuterPort;

import java.util.ArrayList;

public class RuteService {
    private final RuterPort ruterData;

    public RuteService(RuterPort ruterData){
        this.ruterData = ruterData;
    }

    public ArrayList<Rute> hentRuter(){
        return ruterData.hentAlleRuter();
    }

}
