package curso.demo22;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    private EntityManager em;

    @Before
    public void emptyTables() {
        try {
            Connection conn = ConnectionManager.getConnection();
            Statement stmt = conn.createStatement();
            stmt.execute("TRUNCATE TABLE users");
        } catch (Exception e) {
            System.err.println("Error Truncating");
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("cursoDemoPU");
        em = emf.createEntityManager();
    }

    @After
    public void after() {
        em.close();
    }

    private User user1 = new User(1, "Golo");
    private User user2 = new User(2, "Dodo");
    private User user3 = new User(3, "Willy");
    private User user4 = new User(4, "Huesitos");
    private User user5 = new User(5, "Marie");

    @Test
    public void test_create() throws SQLException {
        user1.create(em);
        User user = User.findById(em, 1);
        Assert.assertEquals(user1, user);
    }

    @Test
    public void test_findById() throws SQLException {
        user1.create(em);
        user2.create(em);
        user3.create(em);
        user4.create(em);
        user5.create(em);
        User user = User.findById(em,3);
        Assert.assertEquals(user3, user);
    }

    @Test
    public void test_count() throws SQLException {
        user1.create(em);
        user2.create(em);
        user3.create(em);
        user4.create(em);
        user5.create(em);
        long count = User.count(em);
        Assert.assertEquals(5, count);
    }

    @Test
    public void test_findByPage() throws SQLException {
        user1.create(em);
        user2.create(em);
        //
        user3.create(em);
        user4.create(em);
        //
        user5.create(em);

        List<User> expected = new ArrayList<User>();
        expected.add(user3);
        expected.add(user4);

        List<User> users = User.findByPage(em, 2, 2);
        Assert.assertEquals(expected, users);
    }


    @Test
    public void test_update() throws SQLException {
        user1.create(em);
        user2.create(em);
        user3.create(em);
        user4.create(em);
        user5.create(em);

        user1.setName("Pepe");
        user1.update(em);

        User user = User.findById(em, user1.getId());

        Assert.assertEquals(user1.getName(), user.getName());
    }

    @Test
    public void test_delete() throws SQLException {
        user1.create(em);
        user2.create(em);
        user3.create(em);
        user4.create(em);
        user5.create(em);

        user1.delete(em);

        User user = User.findById(em, user1.getId());

        Assert.assertNull(user);
    }
}
