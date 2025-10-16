package org.Gruppe14.storage.adapter;

import java.sql.Connection;

public class RuteAdapter {


    private Connection connection;

    public RuteAdapter(Connection connection) {
        this.connection = connection;
    }
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
