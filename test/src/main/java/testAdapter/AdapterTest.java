package testAdapter;

import adapter.SqlRuteAdapter;
import adapter.SqlStoppeStedAdapter;
import domain.Rute;
import org.junit.jupiter.api.*;


import testDataBase.TestDatabase;
import domain.StoppeSted;

import java.sql.Array;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;




public class AdapterTest {
    private final static TestDatabase testDB = new TestDatabase();
    private static Connection connection;


    @BeforeAll
    public static void setUpTestDB() throws  Exception {
        connection = testDB.startDB();
        testDB.createTables();

    }
    @BeforeEach
    public void prepareTest() throws Exception {
        testDB.createDymmyData();
    }

    @AfterAll
    public static void demolish() throws Exception{
        testDB.quitDB();
    }




    /**
     * Hjelpe funksjon til å gjøre om stoppestedobjekter i liste til ArrayList med strenger
     *
     *
     * @param liste
     *
     */
    public ArrayList<String> stoppeStedNavnTilString(List<StoppeSted> liste){
        ArrayList<String> stoppeStedNavn = new ArrayList<>();
        for (StoppeSted stoppeSted :liste){
            stoppeStedNavn.add(stoppeSted.getName());
        }

        return stoppeStedNavn;
    }



    @Test
    public void testHentAlleStoppeSteder() throws Exception {

        SqlStoppeStedAdapter adapter = new SqlStoppeStedAdapter();
        ArrayList<StoppeSted> result = adapter.hentAlleStoppeSteder(connection);

        Assertions.assertEquals("Halden", result.get(0).getName());
        Assertions.assertEquals("Sarpsborg", result.get(1).getName());

    }

    @Test
    public void testHentAlleRuter() throws Exception {
        SqlRuteAdapter adapter = new SqlRuteAdapter();
        ArrayList<Rute> result = adapter.hentAlleRuter(connection);

        Rute MossFredrikstad = result.get(0);
        Rute  SarpsborgHalden = result.get(1);


        List<StoppeSted> MFStoppesteder = MossFredrikstad.getStoppeSteder();
        List<StoppeSted> SHStoppesteder = SarpsborgHalden.getStoppeSteder();

        String MFKjoretoy = MossFredrikstad.getKjøretøy().getType();
        String SHKjoretoy = SarpsborgHalden.getKjøretøy().getType();



        Assertions.assertEquals("Moss-Fredrikstad", MossFredrikstad.getName());
        Assertions.assertEquals("Sarpsborg-Halden", SarpsborgHalden.getName());

        Assertions.assertEquals(MFKjoretoy, "Buss");
        Assertions.assertEquals(SHKjoretoy, "Tog");

        Assertions.assertTrue(stoppeStedNavnTilString(MFStoppesteder).contains("Moss"));
        Assertions.assertTrue(stoppeStedNavnTilString(MFStoppesteder).contains("Fredrikstad"));
        Assertions.assertTrue(stoppeStedNavnTilString(SHStoppesteder).contains("Sarpsborg"));
        Assertions.assertTrue(stoppeStedNavnTilString(SHStoppesteder).contains("Halden"));



    }
}
