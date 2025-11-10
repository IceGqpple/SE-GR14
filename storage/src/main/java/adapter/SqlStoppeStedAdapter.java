package adapter;

import database.DBKey;
import database.Database;
import domain.StoppeSted;
import exceptions.DatabaseException;
import exceptions.StoppeStedException;
import port.StoppeStedPort;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlStoppeStedAdapter implements StoppeStedPort {
    public SqlStoppeStedAdapter(){}


    /**
     *  Henter alle stoppesteder i databasen
     *
     *  Kobler til databasen, og utfører spørring.
     *
     * @return sender en liste med stoppested objekter
     */


    //Når denne blir kallt så får du en liste med Stoppested objekter
    @Override
    public ArrayList<StoppeSted> hentAlleStoppeSteder(){
        DBKey key = new DBKey();
        Database database = new Database (key);
        Connection connection = database.startDatabase();


        ArrayList<StoppeSted> stoppeSteder = new ArrayList<>();

        try{
            Statement DBsporring = connection.createStatement();
            ResultSet stedNavnFraDB = DBsporring.executeQuery(String.format("SELECT sted_navn FROM stoppested"));

            while(stedNavnFraDB.next()){
                String stedNavnTilObjekt = stedNavnFraDB.getString(1);
                StoppeSted nyttStoppeSted = new StoppeSted(String.format("%s", stedNavnTilObjekt));
                stoppeSteder.add(nyttStoppeSted);
            }


        } catch(SQLException e){
            database.quitDB();
            throw new DatabaseException("Problem with query" + e.getMessage());
        } catch (StoppeStedException e){
            throw new StoppeStedException("Problem with StoppeSted method" + e.getMessage());
        }
        database.quitDB();
        return stoppeSteder;
    }




    /**
     *  Metode overload for å tillate test av metoden med en annen tilknyttning
     *
     *  Alt er tilsvarende bortsett fra database tilkoblingen
     *
     *  Tar imot en database tilknyttning som argument
     *
     * @return gir en liste med stoppeSted objekter
     */
    public ArrayList<StoppeSted> hentAlleStoppeSteder(Connection connection){


        ArrayList<StoppeSted> stoppeSteder = new ArrayList<>();

        try{
            Statement DBsporring = connection.createStatement();
            ResultSet stedNavnFraDB = DBsporring.executeQuery(String.format("SELECT sted_navn FROM stoppested"));

            while(stedNavnFraDB.next()){
                String stedNavnTilObjekt = stedNavnFraDB.getString(1);
                StoppeSted nyttStoppeSted = new StoppeSted(String.format("%s", stedNavnTilObjekt));
                stoppeSteder.add(nyttStoppeSted);
            }


        } catch(SQLException e){
            throw new DatabaseException("Problem with query" + e.getMessage());
        } catch (StoppeStedException e){
            throw new StoppeStedException("Problem with StoppeSted method" + e.getMessage());
        }

        return stoppeSteder;
    }


}
