package testAdapter;

import adapter.SqlStoppeStedAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import testDataBase.TestDatabase;
import domain.StoppeSted;
import java.sql.Connection;
import java.util.ArrayList;



public class StoppeStedAdapterTest {
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





    @Test
    public void testHentAlleStoppeSteder() throws Exception {

        SqlStoppeStedAdapter adapter = new SqlStoppeStedAdapter();
        ArrayList<StoppeSted> result = adapter.hentAlleStoppeSteder(connection);

        Assertions.assertEquals("Halden", result.get(0).getName());
        Assertions.assertEquals("Sarpsborg", result.get(1).getName());
    }
}
