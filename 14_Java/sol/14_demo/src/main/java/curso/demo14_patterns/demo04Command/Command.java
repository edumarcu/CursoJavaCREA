package curso.demo14_patterns.demo04Command;

import java.io.Serializable;

public interface Command extends Serializable {

    void execute(PointStorage points);

}
