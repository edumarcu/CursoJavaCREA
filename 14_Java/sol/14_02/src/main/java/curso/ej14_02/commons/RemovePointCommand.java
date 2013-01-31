package curso.ej14_02.commons;

public class RemovePointCommand implements Command {

    private boolean ok = false;

    private Point point;

    public RemovePointCommand(Point point) {
        this.point = point;
    }

    public void execute(PointStorage points) {
        if (points.containsPoint(point)) {
            points.removePoint(point);
            ok = true;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
