package curso.ej14_03.commons;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute(PointStorage points);

}
