package curso.ej14_03;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PointStorage {

    private Set<Point> points = new HashSet<Point>();

    public void addPoint(Point p) {
        points.add(p);
    }

    public void removePoint(Point p) {
        points.remove(p);
    }

    public boolean containsPoint(Point p) {
        return points.contains(p);
    }

    public List<Point> listPoints() {
        return new ArrayList<Point>(points);
    }
}
