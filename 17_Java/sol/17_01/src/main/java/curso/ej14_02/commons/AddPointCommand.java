package curso.ej14_02.commons;

public class AddPointCommand implements Command {

    private boolean ok = false;

    private Point point;

    public AddPointCommand(Point point) {
        this.point = point;
    }

    public void execute(PointStorage points) {
        if (!points.containsPoint(point)) {
            points.addPoint(point);
            ok = true;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
