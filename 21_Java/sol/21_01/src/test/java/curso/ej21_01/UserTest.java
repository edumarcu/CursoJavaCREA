package curso.ej21_01;

import curso.ej21_01.db.ConnectionManager;
import curso.ej21_01.db.User;
import curso.ej21_01.db.UserDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    @Before
    public void emptyTables() {
        try {
            Connection conn = ConnectionManager.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("TRUNCATE TABLE users");
        } catch (Exception e) {
            System.err.println("Error Truncating");
        }
    }

    private User user1 = new User(1, "Golo");
    private User user2 = new User(2, "Dodo");
    private User user3 = new User(3, "Willy");
    private User user4 = new User(4, "Huesitos");
    private User user5 = new User(5, "Marie");

    @Test
    public void test_create() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        User user = dao.findUserById(1);
        Assert.assertEquals(user1, user);
    }

    @Test
    public void test_findById() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        dao.create(user4);
        dao.create(user5);
        User user = dao.findUserById(3);
        Assert.assertEquals(user3, user);
    }

    @Test
    public void test_count() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        dao.create(user4);
        dao.create(user5);
        long count = dao.count();
        Assert.assertEquals(5, count);
    }

    @Test
    public void test_findByPage() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        dao.create(user2);
        //
        dao.create(user3);
        dao.create(user4);
        //
        dao.create(user5);

        List<User> expected = new ArrayList<User>();
        expected.add(user3);
        expected.add(user4);

        List<User> users = dao.findUsersByPage(2, 2);
        Assert.assertEquals(expected, users);
    }


    @Test
    public void test_update() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        dao.create(user4);
        dao.create(user5);

        user1.setName("Pepe");
        dao.update(user1);

        User user = dao.findUserById(user1.getId());

        Assert.assertEquals(user1.getName(), user.getName());
    }

    @Test
    public void test_delete() throws SQLException {
        UserDao dao = UserDao.getDao();
        dao.create(user1);
        dao.create(user2);
        dao.create(user3);
        dao.create(user4);
        dao.create(user5);

        dao.delete(user1);

        User user = dao.findUserById(user1.getId());

        Assert.assertNull(user);
    }
}
