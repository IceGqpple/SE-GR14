package org.Gruppe14.core.dto;

public class SøkReiseRequest {
    private final String fraStad;
    private final String tilStad;

    public SøkReiseRequest(String fraStad, String tilStad) {
        this.fraStad = fraStad;
        this.tilStad = tilStad;
    }
    public String getFraStad() {
        return fraStad;
    }
    public String getTilStad() {
        return tilStad;
    }
}
