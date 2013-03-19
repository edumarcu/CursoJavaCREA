package curso.ejercicio4;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//  Register listener in web.xml
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Make ${base available in all the app}
        ServletContext application = sce.getServletContext();
        String base = application.getContextPath();
        application.setAttribute("base", base);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {  }

}
