package curso.ejercicio3.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class PersistenceUtils {

    public static Session createSession() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = config.buildSessionFactory();
        return sf.openSession();
    }

}
