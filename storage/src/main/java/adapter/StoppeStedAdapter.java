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





    //Når denne blir kallt så får du en liste med Stoppested objekter
    public static ArrayList<StoppeSted> hentAlleStoppeSteder(){
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();

        ArrayList<String> temp = new ArrayList<>();
        ArrayList<StoppeSted> stoppeSteder = new ArrayList<>();

        try{
            Statement statement = connection.createStatement();
            ResultSet stedNavn = statement.executeQuery(String.format("SELECT sted_navn FROM stoppested"));
            while(stedNavn.next()){
                String navn = stedNavn.getString(1);
                StoppeSted nyttStoppeSted = new StoppeSted(String.format("%s", navn));
                stoppeSteder.add(nyttStoppeSted);
            }


        } catch(SQLException e){
            database.quitDB();
            throw new DatabaseException("Problem with query" + e.getMessage());
        }
        database.quitDB();
        return stoppeSteder;
    }


}
