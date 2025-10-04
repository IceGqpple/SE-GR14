package model.core;

import java.util.ArrayList;
import java.util.List;

public class Bruker extends User {
    private List<Reise> favorittReiser;

    public Bruker(String fName, String lName){
        super(fName,lName);
        this.favorittReiser = new ArrayList<>();
    }

    public Bruker(String fName, String lName,int id){
        super(fName,lName,id);
        this.favorittReiser = new ArrayList<>();
    }

    public void addFavorittReiser(Reise reise){

    }

    public List<Reise> getFavorittReiser(){
        return favorittReiser;
    }
}
