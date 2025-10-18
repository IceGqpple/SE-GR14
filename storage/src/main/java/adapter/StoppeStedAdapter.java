package adapter;

import database.DBKey;
import database.Database;
import domain.StoppeSted;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StoppeStedAdapter {


    private Connection connection;

    public StoppeStedAdapter(Connection connection) {
        this.connection = connection;
    }



    //Når denne blir kallt så får du en liste med StoppestedObjekter
    public ArrayList<StoppeSted> hentStoppeSted(){
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<StoppeSted> stoppeSteder = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet stedNavn = statement.executeQuery(String.format("SELECT rute_navn FROM stoppested"));
            while(stedNavn.next()){
                String navn = stedNavn.getString(1);
                StoppeSted nyttStoppeSted = new StoppeSted(String.format("%s", navn));
                stoppeSteder.add(nyttStoppeSted);
            }


        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }
        return stoppeSteder;
    }


}
