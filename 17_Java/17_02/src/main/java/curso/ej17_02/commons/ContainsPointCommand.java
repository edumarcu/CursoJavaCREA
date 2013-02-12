package curso.ej17_02.commons;

public class ContainsPointCommand implements Command {

    private boolean contains = false;

    private Point point;

    public ContainsPointCommand(Point point) {
        this.point = point;
    }

    public void execute(PointStorage points) {
        contains = points.containsPoint(point);
    }

    public boolean isContains() {
        return contains;
    }
}
