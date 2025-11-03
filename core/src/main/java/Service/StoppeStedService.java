package Service;

import domain.StoppeSted;
import port.StoppeStedPort;

import java.util.ArrayList;

public class StoppeStedService {
    private final StoppeStedPort stoppeStedData;

    public StoppeStedService(StoppeStedPort stoppeStedData){
        this.stoppeStedData = stoppeStedData;
    }

    public ArrayList<StoppeSted> hentStoppeSted(){
        return stoppeStedData.hentAlleStoppeSteder();
    }
}
