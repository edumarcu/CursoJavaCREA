package curso.ejercicio3;

import curso.ejercicio3.db.PersistenceUtils;
import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Make ${base available in all the app}
        ServletContext application = sce.getServletContext();
        String base = application.getContextPath();
        application.setAttribute("base", base);

        // Inicialize Entity Manager
//        EntityManager em = PersistenceUtils.createEntityManager();
//        application.setAttribute("em", em);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {  }

}
