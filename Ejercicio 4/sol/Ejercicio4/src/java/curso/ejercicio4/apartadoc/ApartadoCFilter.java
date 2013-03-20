package curso.ejercicio4.apartadoc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "ApartadoCFilter", urlPatterns = "/*")
public class ApartadoCFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        LogEntry entry = new LogEntry(
                0,
                request.getRemoteAddr(),
                req.getMethod(),
                req.getRequestURI(),
                null
                );

        entry.save(PersistenceUtils.createEntityManager());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
