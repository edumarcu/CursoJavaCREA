package curso.demo04;

public class Point {

    private int x = 10;

    private int y;

    public Point() {
        System.out.println("Constructor Por defecto: " + this.toString());
    }

    public Point(int x, int y) {
        this();
        set(x, y);
        System.out.println("Constructor Set: " + this.toString());
    }

    public void set(int x, int y) {
        setX(x);
        setY(y);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("<%d,%d>", x, y);
    }

    // 03_03
    public static void add(Point p, int x, int y) {
        p.x += x;
        p.y += y;
    }
    public static Point add(Point p1, Point p2) {
        Point p = new Point();
        p.x = p1.x + p2.x;
        p.y = p1.y + p2.y;
        return p;
    }

    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }
}




