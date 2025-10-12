package adapter;

import database.Database;
import exceptions.DatabaseException;
import exceptions.RuteAdapterException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ruteAdapter {



    private Connection connection;

    public ruteAdapter(Connection connection) {
            this.connection = connection;
    }
 /*   Under arbeid. 
    public void DBAddRute(Rute rute){
        try{
           int N = rute.stoppeSteder.length;

           for (int i = 0; i<=N; i = i+1){

           }
            String sql = "INSERT INTO ruter (kjoretoy_navn %s, kjoretoy_id) VALUES ('rute.ruteNavn %s'); ".formatted(rute.kjoretoyNavn, rute.ruteNavn);

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);


        } catch(
                SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }


    }
*/






}
