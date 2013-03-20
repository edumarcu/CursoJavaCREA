package curso.ejercicio4.apartadoc;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ApartadoCFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //HttpSession session = req.getSession();

       // Boolean index = (Boolean) session.getAttribute("index");

        //if (index != null && index ) {
         //   chain.doFilter(request, response);
        //} else {

           // Create de LogEntry
            LogEntry logEntry = new LogEntry();
            logEntry.setIp(request.getRemoteAddr());
            logEntry.setMethod(req.getMethod());
            logEntry.setPath(req.getRequestURI());
            logEntry.setCreatedAt(new Date());

            // Save on data base
            EntityManager em = PersistenceUtils.createEntityManager();
            logEntry.save(em);
            em.close();

            // Retrieve all the logEntries and set as application attribute
           // List<LogEntry> log = (List<LogEntry>) req.getServletContext().getAttribute("log");
            //log.add(logEntry);
            //req.getServletContext().setAttribute("log", log);

            chain.doFilter(request, response);

            // Redirect to view
            String base = (String) request.getServletContext().getAttribute("base");

            HttpServletResponse resp = (HttpServletResponse) response;
           // resp.sendRedirect(base + req.getRequestURI());
        //}
    }

    @Override
    public void destroy() {}

}