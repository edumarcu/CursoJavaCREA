package curso.demo07;

public class Demo03 {

    public static final int NUMBER = 3;

    public static final Point POINT = new Point(3, 5);

    public static final PointInmutable POINT_INMUTABLE = new PointInmutable(3, 5);

    public static void main(String[] args) {
        System.out.println("NUMBER = " + NUMBER);

        final int i = 5;
        System.out.println("i = " + i);

        final int j;
        if (Math.random() > 0.5) {
            j = 0;
        } else {
            j = 1;
        }
//        j = 4;

        System.out.println("POINT");
        System.out.println(POINT);
        POINT.x = 100;
        System.out.println(POINT);

        System.out.println("POINT_INMUTABLE");
        System.out.println(POINT_INMUTABLE);
//        POINT_INMUTABLE.x = 100;
//        System.out.println(POINT_INMUTABLE);
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }
}

class PointInmutable {
    private int x, y;

    public PointInmutable(int x, int y) {
        this.x = x;
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
        return "<" + x + "," + y + ">";
    }
}