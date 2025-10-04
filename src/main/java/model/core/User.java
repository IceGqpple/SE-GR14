package model.core;

public class User {

    private String fName;
    private String lName;
    private int id;

    public User(String fName, String lName){
        this.fName = fName;
        this.lName = lName;
    }

    public User(String fName, String lName, int id){
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }

    public void setfName(String fName){
        this.fName = fName;
    }

    public String getfName(){
        return fName;
    }

    public void setlName(String lName){
        this.lName = lName;
    }

    public String getlName(){
        return lName;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }
}

