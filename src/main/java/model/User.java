package model;

public class User {

    private String fName;
    private String lName;
    private int id;

    public User(String fName, String lName, int id){
        this.fName = fName;
        this.lName = lName;
        this.id = id;
    }


    public void setfName(String fName){
        this.fName = fName;
    }
    public void setlName(String lName){
        this.lName = lName;
    }
    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }
    public int getId(){
        return id;
    }
}

