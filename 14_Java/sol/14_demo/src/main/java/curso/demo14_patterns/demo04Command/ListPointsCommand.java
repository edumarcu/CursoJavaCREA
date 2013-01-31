package curso.demo14_patterns.demo04Command;

import java.util.List;

public class ListPointsCommand implements Command {

    private List<Point> list;

    public void execute(PointStorage points) {
        list = points.listPoints();
    }

    public List<Point> getPoints() {
        return list;
    }
}
