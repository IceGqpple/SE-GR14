package testDataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestDatabase {
    public final static String DB_NAME = "testdb";
    public final static String URL = "jdbc:h2:mem:memtestdb" + DB_NAME + ";MODE=MySQL;DATABASE_TO_LOWER=TRUE;";
    public final static String USERNAME = "user;";
    public final static  String PASSWORD = "password";

    protected Connection connection;



    public Connection startDB() throws Exception{
        Class.forName("org.h2.Driver");
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return connection;
    }
    public void quitDB() throws Exception {
        connection.close();
    }

    public void createTables() throws Exception{
        try (Statement statement = connection.createStatement()){
            statement.execute("CREATE TABLE stoppested (stoppested_id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "sted_navn VARCHAR(20))");
            statement.execute("CREATE TABLE rute (rute_id INT AUTO_INCREMENT PRIMARY KEY, rute_navn VARCHAR(45))");
            statement.execute("CREATE TABLE rute_view (id INT AUTO_INCREMENT PRIMARY KEY,rute_navn VARCHAR(45), kjoretoy_navn VARCHAR(45), sted_navn VARCHAR(45))");
        }
    }

    public void createDymmyData() throws Exception{
        try (Statement statement = connection.createStatement()){
            insertIntoStoppeSteder("Halden");
            insertIntoStoppeSteder("Sarpsborg");
            insertIntoStoppeSteder("Moss");
            insertIntoStoppeSteder("Fredrikstad");



            insertIntoRute("Moss-Fredrikstad");
            insertIntoRute("Sarpsborg-Halden");

            insertIntoRuteView("Moss-Fredrikstad", "Buss", "Moss");
            insertIntoRuteView("Moss-Fredrikstad", "Buss", "Fredrikstad");

            insertIntoRuteView("Sarpsborg-Halden", "Tog", "Sarpsborg");
            insertIntoRuteView("Sarpsborg-Halden", "Tog", "Halden");
        }
    }

    public void insertIntoStoppeSteder(String navn) throws Exception {
        String sql = "INSERT INTO stoppested (sted_navn)" + "VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,navn);
            preparedStatement.executeUpdate();
        }
    }

    public void insertIntoRute(String ruteNavn) throws Exception{
        String sql = "INSERT INTO rute (rute_navn)" + "VALUES (?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, ruteNavn);
            preparedStatement.executeUpdate();
        }
    }


    public void insertIntoRuteView(String ruteNavn, String kjoretoyNavn, String stedNavn) throws Exception{
        String sql = "INSERT INTO rute_view (rute_navn, kjoretoy_navn, sted_navn)" + "VALUES (?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, ruteNavn);
            preparedStatement.setString(2, kjoretoyNavn);
            preparedStatement.setString(3, stedNavn);
            preparedStatement.executeUpdate();
        }
    }



}
