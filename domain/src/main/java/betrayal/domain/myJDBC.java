package betrayal.domain;

import java.sql.Connection;
import java.sql.DriverManager;

public class myJDBC {

    public static void main(String[] args) {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/betrayaldb", "root", "wachtwoord");
    }

}https:// www.youtube.com/watch?v=e8g9eNnFpHQ
