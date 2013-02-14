package curso.ej14_02.commons;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute(PointStorage points);

}
