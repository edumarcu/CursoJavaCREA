package curso.ej21_01.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public long count() {
        return 0;
    }

    public List<User> findUsersByPage(int page, int usersPerPage) {
        return null;
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

    public User update(User user) {
        return null;
    }

    public boolean delete(User user) {
        return false;
    }

}
