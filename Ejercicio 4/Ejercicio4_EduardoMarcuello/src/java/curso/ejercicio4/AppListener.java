package curso.ejercicio4;

import curso.ejercicio4.apartadoc.LogEntry;
import java.util.ArrayList;
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
        
        // Create Log
         application.setAttribute("log", new ArrayList<LogEntry>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {  }

}
