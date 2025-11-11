package Service;

import domain.StoppeSted;
import exeption.RuteException;
import port.StoppeStedPort;

import java.util.ArrayList;

public class StoppeStedService {
    private final StoppeStedPort stoppeStedData;

    public StoppeStedService(StoppeStedPort stoppeStedData){
        this.stoppeStedData = stoppeStedData;
    }

    public ArrayList<StoppeSted> hentStoppeSted(){
        try {
            return stoppeStedData.hentAlleStoppeSteder();
        }
        catch (RuteException e){
            throw new RuntimeException("kunne ikke hente stoppesteder" + e.getMessage());
        }
    }
}
