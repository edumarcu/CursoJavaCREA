package curso.ej14_03;

/**
 * Command server
 * @author EM
 */
public class ContainsPointCommand implements Command {

    private boolean ok = false;

    private Point point;

    public ContainsPointCommand(Point point) {
        this.point = point;
    }

    public void execute(PointStorage points) {
        if (points.containsPoint(point)) {
            ok = true;
        }
    }

    public boolean isOk() {
        return ok;
    }
}
