package database;


import exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String url;
    private String username;
    private String password;
    private Connection connection;



    public Database(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public Database(DBKey dbKey) {
        this.url = dbKey.url;
        this.username = dbKey.username;
        this.password = dbKey.password;
    }





    public Connection startDatabase() throws DatabaseException{
        try{
            connection = DriverManager.getConnection(url, username,password);
            return connection;
        }
        catch (SQLException e){
            throw new DatabaseException("Connection to database failed" + e.getMessage());
        }
    }


    public Connection getConnection() {
        return connection;
    }


    public void quitDB() throws DatabaseException{
        try{
            connection.close();

        }catch (SQLException e){
            throw new DatabaseException("Could not stop DB connection" + e.getMessage());
        }
    }
}
