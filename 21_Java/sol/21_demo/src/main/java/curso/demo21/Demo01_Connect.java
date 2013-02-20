package curso.demo21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01_Connect {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load Driver Class
        // Not needed after Java 6, JDBC 4.0
        //Class c = com.mysql.jdbc.Driver.class;
        //Class.forName("com.mysql.jdbc.Driver");

        // Get a connection
        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "";
        Connection conn = DriverManager.getConnection(url, user, pass);

        System.out.println("Connected to MySQL!");

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name FROM users");

        while (rs.next()) {
            int id = rs.getInt("id"); // rs.getInt(1);
            String name = rs.getString("name");

            System.out.println("ID:" + id + " Name:" + name);
        }

    }
}
