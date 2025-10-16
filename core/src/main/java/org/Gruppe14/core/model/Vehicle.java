package org.Gruppe14.core.model;

public abstract class Vehicle {
    private String type;

    public Vehicle(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}