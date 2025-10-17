package model.core.dto;

import java.util.List;

public class OpprettRuteRequest {
    private final String ruteNavn;
    private final String vehicleType;
    private final String vehicleClass;
    private final List<String> stoppSted;

    public OpprettRuteRequest( String ruteNavn, String vehicleType, String vehicleClass, List<String> stoppSteder){
        this.ruteNavn = ruteNavn;
        this.vehicleType = vehicleType;
        this.vehicleClass = vehicleClass;
        this.stoppSted = stoppSteder;
    }

    public String getRuteNavn() {
        return ruteNavn;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public List<String> getStoppSteder() {
        return stoppSted;
    }
}
