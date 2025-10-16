package org.Gruppe14.core.dto;

import java.util.List;

public class RuteResult {
    private final String ruteNavn;
    private final String vehicleType;
    private final String vehiclClass;
    private final List<String> stoppSteder;

    public RuteResult(String ruteNavn, String vehicleType, String vehiclClass, List<String> stoppSteder) {
        this.ruteNavn = ruteNavn;
        this.vehicleType = vehicleType;
        this.vehiclClass = vehiclClass;
        this.stoppSteder = stoppSteder;
    }

    public String getRuteNavn() {
        return ruteNavn;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getVehiclClass() {
        return vehiclClass;
    }

    public List<String> getStoppSteder() {
        return stoppSteder;
    }

    public int getAntallStopp() {
        return stoppSteder.size(); // beregnes automatisk
    }
}
