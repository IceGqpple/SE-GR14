package model;

public abstract class Kjøretøy {
    private String type;

    public Kjøretøy(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}
