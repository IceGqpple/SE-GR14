package model;

import java.util.ArrayList;
import java.util.List;

public class Bruker extends User {
    private List<Reise> favorittReiser;

    public Bruker(String fName, String lName,int id){
        super(fName,lName,id);
        this.favorittReiser = new ArrayList<>();
    }
    public void addFavorittReise(Reise reise){

    }
    public List<Reise> getFavorittReiser(){
        return favorittReiser;
    }
}
