package runDB;

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
            Database database = new Database ("jdbc:mysql://127.0.0.1:3306/se", "Analysis", "Softwargruppe14");
            Connection connection = database.startDatabase();
            Statement statement = connection.createStatement();
            ResultSet reusltSet = statement.executeQuery("select * from kjoretoy");
            while(reusltSet.next()){
                System.out.println(reusltSet.getString(2)+ " " + reusltSet.getString(1) + "\n");
            }
        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }
        //Test legg inn
        try{
            Database database = new Database ("jdbc:mysql://127.0.0.1:3306/se", "Analysis", "Softwargruppe14");
            Connection connection = database.startDatabase();
            Statement stmt = connection.createStatement();
            String sql = "INSERT INTO kjoretoy (kjoretoy_navn) VALUES ('Trikk'); ";
            stmt.executeUpdate(sql);
            ResultSet reusltSet = stmt.executeQuery("select * from kjoretoy");
            while(reusltSet.next()){
                System.out.println(reusltSet.getString(2)+ " " + reusltSet.getString(1));
            }
        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }









    }
}