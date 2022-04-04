package betrayal.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import betrayal.domain.Character;

public class Database {

    public static final Database database = new Database();

    private static final String url = "jdbc:mysql://localhost:3306/betrayaldb";
    private static final String username = "root";
    private static final String password = "wachtwoord";
    private Connection connection;

    private Database() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            connection = null;
        }
    }

    public Character getCharacterById(int id) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement
                .executeQuery("SELECT * FROM `original characters` WHERE `idOriginal Characters` = " + id);

        Character c = null;
        while (resultSet.next()) {

            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");

            String speedStatsStr = resultSet.getString("Speedstats"); // string from DB split up to array of ints.
            int[] speedStats = Arrays.stream(speedStatsStr.substring(1, speedStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();

            int defaultSpIndex = resultSet.getInt("DefaultSpeed");

            String mightStatsStr = resultSet.getString("Mightstats");
            int[] mightStats = Arrays.stream(mightStatsStr.substring(1, mightStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();

            int defaultMiIndex = resultSet.getInt("DefaultMight");

            String sanityStatsStr = resultSet.getString("Sanitystats");
            int[] sanityStats = Arrays.stream(sanityStatsStr.substring(1, sanityStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();

            int defaultSaIndex = resultSet.getInt("DefaultSanity");

            String knowledgeStatsStr = resultSet.getString("Knowledgestats");
            int[] knowledgeStats = Arrays
                    .stream(knowledgeStatsStr.substring(1, knowledgeStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();

            int defaultKnIndex = resultSet.getInt("DefaultKnowledge");

            c = new Character(name, age, speedStats, defaultSpIndex, mightStats,
                    defaultMiIndex, sanityStats, defaultSaIndex, knowledgeStats, defaultKnIndex);
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("Speedstats"));

        }
        return c;
    }

    public void saveCharacterByPlayer() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("INSERT into saved characters );
                https://www.geeksforgeeks.org/how-to-insert-records-to-a-table-using-jdbc-connection/
    }

}
