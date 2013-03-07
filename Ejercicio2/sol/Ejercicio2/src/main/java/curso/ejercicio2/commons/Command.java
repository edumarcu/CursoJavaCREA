package curso.ejercicio2.commons;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute(Library library);

}
