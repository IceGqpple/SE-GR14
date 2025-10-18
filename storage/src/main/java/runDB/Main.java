package runDB;

import adapter.RuteAdapter;
import database.DBKey;
import database.Database;
import domain.Rute;
import domain.StoppeSted;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Test hente ut
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();

        //Tester RuteAdapter. Ved å hente ut alle ruter i listen og alle stoppesteder på ruten
        RuteAdapter ruteAdapter = new RuteAdapter(connection);
        ArrayList<Rute> ruter = ruteAdapter.hentRuter();
        for(Rute rute : ruter){
            System.out.println(rute.getName());
            List<StoppeSted> stoppeSteder = rute.getStoppeSteder();
            for(StoppeSted stoppeSted : stoppeSteder){
                System.out.println("  " + stoppeSted.getName());
            }
        }
/*
        try{
            String st ="Moss";
            String sl = "Halden";
            DBKey key = new DBKey();
            Database database = new Database (key);
            Connection connection = database.startDatabase();
            Statement statement = connection.createStatement();
            ResultSet reusltSet = statement.executeQuery(String.format("SELECT distinct st.rute_navn \n" +
                    "\tFROM rute_view as st \n" +
                    "\tJOIN rute_view as sl ON st.rute_id = sl.rute_id \n" +
                    "    WHERE st.sted_navn = 'Moss' \n" +
                    "    AND sl.sted_navn = 'Halden' \n" +
                    "    AND st.rekkefolge < sl.rekkefolge;",st, sl));

            while(reusltSet.next()){
                System.out.println(reusltSet.getString(1));
            }
        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }

*/









    }
}