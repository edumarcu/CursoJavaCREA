package curso.demo33.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Action {

    protected String base;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public abstract void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
