package adapter;
import database.Database;
import database.DBKey;
import domain.*;
import exceptions.DatabaseException;
import port.RuterPort;

import java.sql.*;
import java.util.ArrayList;

public class SqlRuteAdapter implements RuterPort {
        public SqlRuteAdapter(){};
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
         * @return sender en liste med rute objekter.
         * */
    @Override
    public ArrayList<Rute> hentAlleRuter() {
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();

        Rute rute;
        ArrayList<Rute> ruter = new ArrayList<>();
        ArrayList<String> RuteNavnListe = new ArrayList<>();


        //Funksjonen er satt opp slik i to try catch blokker. Den første blokken henter navnene på rutene blir hentet ut
        try {
            Statement DBSporring = connection.createStatement();
            ResultSet RuteNavnFraDB = DBSporring.executeQuery("SELECT rute_navn from rute");

            while (RuteNavnFraDB.next()) {
                String RuteNavnTilListe = RuteNavnFraDB.getString(1);
                RuteNavnListe.add(RuteNavnTilListe);

            }
        } catch (SQLException e) {
            database.quitDB();
            throw new DatabaseException("Problem with first query" + e.getMessage());
        }

        //I den andre blokken brukes navnene på rutene til å hente ut å lage nye spørringer for å hente data til å konstruere rutene.
        int i = 0;
        while(i < RuteNavnListe.size()){
            try {
                Statement DBSporring = connection.createStatement();
                String RuteNavnTilSporring = RuteNavnListe.get(i);
                ArrayList<String> StedsNavnTilRute = new ArrayList<>();
                Kjøretøy kjoretoy = null;

                //Her så lages det en spørring for hver rute
                ResultSet ResultatFraSporringView = DBSporring.executeQuery(String.format("SELECT rute_navn, kjoretoy_navn, sted_navn from rute_view where rute_navn = '%s' ", RuteNavnTilSporring));

                while(ResultatFraSporringView.next()){

                    //Her legges stoppestedene inn i en ArrayList som blir gitt som parameter til konstruktøren
                    StedsNavnTilRute.add(ResultatFraSporringView.getString(3));

                    //Her hentes kjøretøy typen
                    if(kjoretoy == null){
                        if("Buss".equals(ResultatFraSporringView.getString(2))){
                            kjoretoy = new Buss("Buss");
                        } else{
                            kjoretoy = new Tog("Tog");
                        }
                    }

                }
                //Her blir den nye ruten konstruert og lagt inn i listen som blir returnert.
                rute = new Rute(RuteNavnTilSporring, kjoretoy, StedsNavnTilRute);
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


    public ArrayList<Rute> hentAlleRuter(Connection connection) {



        Rute rute;
        ArrayList<Rute> ruter = new ArrayList<>();
        ArrayList<String> RuteNavnListe = new ArrayList<>();


        //Funksjonen er satt opp slik i to try catch blokker. Den første blokken henter navnene på rutene blir hentet ut
        try {
            Statement DBSporring = connection.createStatement();
            ResultSet RuteNavnFraDB = DBSporring.executeQuery("SELECT rute_navn from rute");

            while (RuteNavnFraDB.next()) {
                String RuteNavnTilListe = RuteNavnFraDB.getString(1);
                RuteNavnListe.add(RuteNavnTilListe);

            }
        } catch (SQLException e) {

            throw new DatabaseException("Problem with first query" + e.getMessage());
        }

        //I den andre blokken brukes navnene på rutene til å hente ut å lage nye spørringer for å hente data til å konstruere rutene.
        int i = 0;
        while(i < RuteNavnListe.size()){
            try {
                Statement DBSporring = connection.createStatement();
                String RuteNavnTilSporring = RuteNavnListe.get(i);
                ArrayList<String> StedsNavnTilRute = new ArrayList<>();
                Kjøretøy kjoretoy = null;

                //Her så lages det en spørring for hver rute
                ResultSet ResultatFraSporringView = DBSporring.executeQuery(String.format("SELECT rute_navn, kjoretoy_navn, sted_navn from rute_view where rute_navn = '%s' ", RuteNavnTilSporring));

                while(ResultatFraSporringView.next()){

                    //Her legges stoppestedene inn i en ArrayList som blir gitt som parameter til konstruktøren
                    StedsNavnTilRute.add(ResultatFraSporringView.getString(3));

                    //Her hentes kjøretøy typen
                    if(kjoretoy == null){
                        if("Buss".equals(ResultatFraSporringView.getString(2))){
                            kjoretoy = new Buss("Buss");
                        } else{
                            kjoretoy = new Tog("Tog");
                        }
                    }

                }
                //Her blir den nye ruten konstruert og lagt inn i listen som blir returnert.
                rute = new Rute(RuteNavnTilSporring, kjoretoy, StedsNavnTilRute);
                ruter.add(rute);
            } catch (SQLException e) {

                throw new DatabaseException("Problem with second query" + e.getMessage());

            }
            i++;
        }



        return ruter;
    }








}
