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

    public void DBAddRute(){
        try{
            String sql = "INSERT INTO kjoretoy (kjoretoy_navn) VALUES ('Trikk'); ";

            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch(
                SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }
    }







}
