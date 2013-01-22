package curso.ej03_01;



public class App {

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.set(3, 5);
        Point p2 = new Point();
        p2.set(10, 13);
        PointF p3 = new PointF();
        p3.set(3, 5);
        PointF p4 = new PointF();
        p4.set(10, 13);

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());
        System.out.println(p4.toString());
    }
}
