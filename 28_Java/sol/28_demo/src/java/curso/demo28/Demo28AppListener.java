package curso.demo28;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Demo28AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();

        String appName = application.getInitParameter("appName");
        String appVersion = application.getInitParameter("appVersion");

        application.setAttribute("appName", appName);
        application.setAttribute("appVersion", appVersion);

        application.setAttribute("base", application.getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

}
