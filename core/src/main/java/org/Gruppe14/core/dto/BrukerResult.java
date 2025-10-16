package org.Gruppe14.core.dto;

public class BrukerResult {
    private String fName;
    private String lName;
    private int id;

    public BrukerResult(String fName, String lName, int id){
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }
    public String getfName() {
        return fName;
    }
    public String getlName() {
        return lName;
    }
    public int getId() {
        return id;
    }
}
