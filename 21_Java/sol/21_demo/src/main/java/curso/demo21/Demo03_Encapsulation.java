package curso.demo21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo03_Encapsulation {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Connection conn = getConnection();
        System.out.println("Connected to MySQL!");

        System.out.println(findById(conn, 2));
        System.out.println(findById(conn, 3));

    }

    public static Connection getConnection() throws SQLException {
        // Get a connection
        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "";
        return DriverManager.getConnection(url, user, pass);
    }

    public static User findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT id, name FROM users WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        int i = 1;
        stmt.setInt(i++, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            int user_id = rs.getInt("id");
            String user_name = rs.getString("name");
            return new User(user_id, user_name);
        }
        return null;
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "#" + id + " " + name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}