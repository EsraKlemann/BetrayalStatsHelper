package betrayal.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mysql.cj.xdevapi.Result;

import betrayal.domain.Character;
import betrayal.api.models.CharacterStatusDTO;
import betrayal.api.models.CharacterSaveDTO;

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
            // System.out.println(resultSet.getString("name"));
            // System.out.println(resultSet.getString("Speedstats"));

        }
        return c;
    }

    public boolean saveCharacterByPlayer(CharacterSaveDTO csavedto) throws SQLException {

        String name = csavedto.getName();
        int age = csavedto.getAge();
        int[] speedStats = csavedto.getSpeedStats();
        String speedStatsStr = Arrays.toString(speedStats);
        int defaultSpIndex = csavedto.getSpeedIndex()[0];
        int[] mightStats = csavedto.getMightStats();
        String mightStatsStr = Arrays.toString(mightStats);
        int defaultMiIndex = csavedto.getMightIndex()[0];
        int[] sanityStats = csavedto.getSanityStats();
        String sanityStatsStr = Arrays.toString(sanityStats);
        int defaultSaIndex = csavedto.getSanityIndex()[0];
        int[] knowledgeStats = csavedto.getKnowledgeStats();
        String knowledgeStatsStr = Arrays.toString(knowledgeStats);
        int defaultKnIndex = csavedto.getKnowledgeIndex()[0];
        int originalID = csavedto.getOriginalID();
        String userName = csavedto.getUserName();

        String query = "INSERT into `saved characters` (NameChar, Age, SpeedStats, DefaultSpeed, MightStats, DefaultMight, SanityStats, DefaultSanity, KnowledgeStats, DefaultKnowledge, originalID, namePlayer) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = connection.prepareStatement(query);
        preparedStmt.setString(1, name);
        preparedStmt.setInt(2, age);
        preparedStmt.setString(3, speedStatsStr);
        preparedStmt.setInt(4, defaultSpIndex);
        preparedStmt.setString(5, mightStatsStr);
        preparedStmt.setInt(6, defaultMiIndex);
        preparedStmt.setString(7, sanityStatsStr);
        preparedStmt.setInt(8, defaultSaIndex);
        preparedStmt.setString(9, knowledgeStatsStr);
        preparedStmt.setInt(10, defaultKnIndex);
        preparedStmt.setInt(11, originalID);
        preparedStmt.setString(12, userName);

        return preparedStmt.execute();
    }

    public Character getCharacterByIdUsername(int id, String userName) throws SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement
                .executeQuery(
                        "SELECT * FROM `saved characters` WHERE `originalID` = " + id + " AND `namePlayer` = \""
                                + userName + "\"");

        Character c = null;
        while (resultSet.next()) {

            String name = resultSet.getString("NameChar");
            int age = resultSet.getInt("Age");
            String speedStatsStr = resultSet.getString("Speedstats"); // string from DB split up to array of ints.
            int[] speedStats = Arrays.stream(speedStatsStr.substring(1, speedStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();
            int defaultSpIndex = resultSet.getInt("DefaultSpeed");
            String mightStatsStr = resultSet.getString("MightStats");
            int[] mightStats = Arrays.stream(mightStatsStr.substring(1, mightStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();
            int defaultMiIndex = resultSet.getInt("DefaultMight");
            String sanityStatsStr = resultSet.getString("SanityStats");
            int[] sanityStats = Arrays.stream(sanityStatsStr.substring(1, sanityStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();
            int defaultSaIndex = resultSet.getInt("DefaultSanity");
            String knowledgeStatsStr = resultSet.getString("KnowledgeStats");
            int[] knowledgeStats = Arrays
                    .stream(knowledgeStatsStr.substring(1, knowledgeStatsStr.length() - 1).split(", "))
                    .mapToInt(s -> Integer.parseInt(s)).toArray();
            int defaultKnIndex = resultSet.getInt("DefaultKnowledge");

            c = new Character(name, age, speedStats, defaultSpIndex, mightStats,
                    defaultMiIndex, sanityStats, defaultSaIndex, knowledgeStats, defaultKnIndex);

        }
        return c;
    }

    public List<String> getHauntByOmenAndRoom(String room, String omen) throws SQLException {
        Statement statement = connection.createStatement();

        int hauntID = 0;
        List<String> hauntInfo = new ArrayList<String>();

        ResultSet firstResultSet = statement
                .executeQuery("SELECT `" + omen + "` FROM `haunt selection` WHERE `room` = \"" + room + "\"");

        while (firstResultSet.next()) {
            hauntID = firstResultSet.getInt(omen);
            System.out.println(hauntID);
        }

        ResultSet secondResultSet = statement
                .executeQuery("SELECT * FROM `haunt story tomes` where `idHaunt Story Tomes` = \"" + hauntID + "\"");

        while (secondResultSet.next()) {
            String haunt = secondResultSet.getString("haunt");
            String survivalStory = secondResultSet.getString("survivaltome");
            String traitorStory = secondResultSet.getString("traitorstome");
            hauntInfo.add(haunt);
            hauntInfo.add(survivalStory);
            hauntInfo.add(traitorStory);
            System.out.println(haunt);
        }

        return hauntInfo;
    }
}
