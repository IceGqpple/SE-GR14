package adapter;
import database.Database;
import database.DBKey;
import domain.*;
import exceptions.DatabaseException;
import java.sql.*;
import java.util.ArrayList;

public class RuteAdapter {





        /** Henter en liste over alle tilgjengelige ruter fra databasen.
         *
         * Metoden har innebygd database tilkobling og kutting
         * Dette gjør funksjonen noe trengere, men også enklere å kalle
         *
         *
         * Metoden finner først alle rutenavn, og slår deretter opp
         * stoppestedene og kjøretøyet (Buss eller Tog) for hver enkelt rute.
         *
         * Metoden returnerer en ArrayList som inneholder ruteobjekter
         *
         * */

    public static ArrayList<Rute> hentAlleRuter() {
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();

        Rute rute;
        ArrayList<Rute> ruter = new ArrayList<>();
        ArrayList<String> navnRute = new ArrayList<>();


        //Funksjonen er satt opp slik i to try catch blokker. Den første blokken henter navnene på rutene blir hentet ut
        try {
            Statement statement = connection.createStatement();
            ResultSet ruteNavn = statement.executeQuery("SELECT rute_navn from rute");

            while (ruteNavn.next()) {
                String navn = ruteNavn.getString(1);
                navnRute.add(navn);

            }
        } catch (SQLException e) {
            database.quitDB();
            throw new DatabaseException("Problem with first query" + e.getMessage());
        }

        //I den andre blokken brukes navnene på rutene til å hente ut å lage nye spørringer for å hente data til å konstruere rutene.
        int i = 0;
        while(i < navnRute.size()){
            try {
                Statement statement = connection.createStatement();
                String ruteNavn = navnRute.get(i);
                ArrayList<String> tempSteder = new ArrayList<>();
                Kjøretøy kjoretoy = null;
                //Her så lages det en spørring for hver rute
                ResultSet view_rute = statement.executeQuery(String.format("SELECT rute_navn, kjoretoy_navn, sted_navn from rute_view where rute_navn = '%s' ", ruteNavn));
                while(view_rute.next()){

                    //Her legges stoppestedene inn i en ArrayList som blir gitt som parameter til konstruktøren
                    tempSteder.add(view_rute.getString(3));

                    //Her hentes kjøretøy typen
                    if(kjoretoy == null){
                        if("Buss".equals(view_rute.getString(2))){
                            kjoretoy = new Buss("Buss");
                        } else{
                            kjoretoy = new Tog("Tog");
                        }
                    }

                }
                //Her blir den nye ruten konstruert og lagt inn i listen som blir returnert.
                rute = new Rute(ruteNavn, kjoretoy, tempSteder);
                ruter.add(rute);
            } catch (SQLException e) {
                database.quitDB();
                throw new DatabaseException("Problem with second query" + e.getMessage());

            }
            i++;
        }


        database.quitDB();
        return ruter;
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
