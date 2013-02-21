package curso.demo22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection() throws SQLException {
        // Get a connection
        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "password";
        return DriverManager.getConnection(url, user, pass);
    }

}
