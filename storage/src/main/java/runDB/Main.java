package runDB;

import adapter.SqlStoppeStedAdapter;
import database.DBKey;
import database.Database;
import domain.StoppeSted;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();

        SqlStoppeStedAdapter adapter = new SqlStoppeStedAdapter();
        ArrayList<StoppeSted> s = adapter.hentAlleStoppeSteder(connection);
        for(StoppeSted stoppeSted : s){
            System.out.println(stoppeSted.getName());
        }


    }
}