package curso.ej14_03;

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
