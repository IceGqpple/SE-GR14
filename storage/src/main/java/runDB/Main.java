package runDB;

import database.DBKey;
import database.Database;
import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        //Test hente ut



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











    }
}