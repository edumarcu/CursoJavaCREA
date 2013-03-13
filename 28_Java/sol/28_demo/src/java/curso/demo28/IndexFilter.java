package curso.demo28;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        Boolean index = (Boolean) session.getAttribute("index");

        if (index != null && index ) {
            chain.doFilter(request, response);
        } else {
            String base = request.getServletContext().getContextPath();

            HttpServletResponse resp = (HttpServletResponse) response;
            resp.sendRedirect(base + "/error.jsp");
        }
    }

    @Override
    public void destroy() {}

}
