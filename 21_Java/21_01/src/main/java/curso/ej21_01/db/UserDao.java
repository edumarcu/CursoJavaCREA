package curso.ej21_01.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private Connection conn;

    public UserDao(Connection conn) {
        this.conn = conn;
    }

    public static UserDao getDao() throws SQLException {
        return new UserDao(ConnectionManager.getConnection());
    }

    // Query Methods

    public User findUserById(long id) throws SQLException {
        String sql = "SELECT id, name FROM user WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            return user;
        }
        return null;
    }

    public long count() throws SQLException {
        String sql = "SELECT COUNT(*) FROM user";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getLong(1);
        }
        return 0;
    }

    public List<User> findUsersByPage(int page, int usersPerPage) throws SQLException {
        String sql = "SELECT id, name FROM user ORDER BY id LIMIT ?,?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, (page - 1) * usersPerPage);
        stmt.setLong(2, usersPerPage);
        ResultSet rs = stmt.executeQuery();

        List<User> users = new ArrayList<User>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            users.add(user);
        }
        return users;
    }

    public User create(User user) throws SQLException {
        // INSERT
        String sql = "INSERT INTO user (id, name) VALUES (NULL, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, user.getName());

        int count = stmt.executeUpdate();
        if (count != 1) {} // ERROR

        // FETCH ID
        ResultSet rs = stmt.getGeneratedKeys();
        /*
        sql = "SELECT LAST_INSERT_ID()";
        stmt = conn.prepareStatement(sql);
        stmt.executeQuery();

        ResultSet rs = stmt.getResultSet();
        */
        if (rs.next()) {
            long lastId = rs.getLong(1);
            return new User(lastId, user.getName());
            // return findUserById(lastId);
        }

        return null;
    }

    public User update(User user) throws SQLException {
        String sql = "UPDATE  user  SET name = ? WHERE id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setLong(2, user.getId());

        int count = stmt.executeUpdate();
        if (count != 1) { // ERROR
            return null;
        } else {
            return findUserById(user.getId());
        }
    }

    public boolean delete(User user) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?;";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1, user.getId());

        int count = stmt.executeUpdate();
        if (count != 1) { // ERROR
            return false;
        } else {
            return true;
        }
    }

}
