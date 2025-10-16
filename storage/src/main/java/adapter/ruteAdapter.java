package adapter;
import database.Database;
import database.DBKey;
import domain.Kjøretøy;
import domain.Reise;
import domain.Rute;
import domain.StoppeSted;
import exceptions.DatabaseException;
import java.sql.*;
import java.util.ArrayList;

public class ruteAdapter {



    private Connection connection;

    public ruteAdapter(Connection connection) {
        this.connection = connection;
    }

    //Funksjon til å hente ut ruter fra db basert på navnet på ruten.
    public Rute hentRute(String ruteNavn) {
        Rute rute;
        ArrayList<String> stoppested = new ArrayList<>();
        Kjøretøy kjoretoy;
        try {
            DBKey key = new DBKey();
            Database database = new Database (key);
            Connection connection = database.startDatabase();
            Statement statement = connection.createStatement();


            ResultSet result = statement.executeQuery(String.format("SELECT kjoretoy_navn, sted_navn \n" +
                    "\tfrom rute_view \n" +
                    "    where rute_navn = '%s' ", ruteNavn));


            while(result.next()){
                stoppested.add(result.getString(2));
            }
            String type = result.getString(1);
            kjoretoy = new Kjøretøy(type);
            rute = new Rute(ruteNavn, kjoretoy , stoppested);

            database.quitDB();
        } catch (SQLException e) {
            throw new DatabaseException("Problem with query" + e.getMessage());
        }
    return rute;
    }




    //Denne funksjonen tar imot 2 stoppesteder som parametere for å hente ut rutenavn i en liste.
    public ArrayList<String> ruteSok(StoppeSted start, StoppeSted slutt){
        ArrayList<String> passendeRuter = new ArrayList<>();
        try{
            //Har bare laget en klasse for API nøkkelen og bruker denne til å opprette kontakt med databasen.
            DBKey key = new DBKey();
            Database database = new Database (key);
            Connection connection = database.startDatabase();
            Statement statement = connection.createStatement();

            //Henter navnene til stoppested objektene. for å gi dem so parametere til spørringen
            String st = start.getName();
            String sl = slutt.getName();

            //Lagret spørring til databasen som henter ut ruter som inneholder stoppestedene.
            ResultSet r = statement.executeQuery(String.format("SELECT distinct\n" +
                    " st.rute_navn\n" +
                    " FROM rute_view as st\n" +
                    " JOIN rute_view as sl ON st.rute_id = sl.rute_id\n" +
                    " WHERE \n" +
                    "\tst.sted_navn = '%s'\n" +
                    "    AND sl.sted_navn = '%s'\n" +
                    "    AND st.rekkefolge < sl.rekkefolge;"));



            while(r.next()){
                passendeRuter.add(r.getString(1));
            }
            database.quitDB();

        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        }

        return passendeRuter;
    }






}
