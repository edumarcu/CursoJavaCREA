package curso.demo21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo02_Params {

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

        String sql = "SELECT id, name FROM users WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        int i = 1;
        stmt.setInt(i++, 3);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id"); // rs.getInt(1);
            String name = rs.getString("name");

            System.out.println("ID:" + id + " Name:" + name);
        } else {
            System.out.println("No user with that id.");
        }

    }
}
