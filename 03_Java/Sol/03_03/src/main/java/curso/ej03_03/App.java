package curso.ej03_03;

public class App {

    public static void main(String[] args) {
        Point p1 = new Point();
        p1.set(3, 5);
        Point p2 = new Point();
        p2.set(5, 8);

        System.out.println("p1 + <13,20>");
        System.out.println(p1.toString());
        Point.add(p1, 13, 20);
        System.out.println(p1.toString());

        System.out.println("p1 + p2");
        System.out.println("P1: " + p1.toString());
        System.out.println("P2: " + p2.toString());
        Point p3 = Point.add(p1, p2);
        System.out.println("P1 + P2: " + p3.toString());

        System.out.println("p1 + <13,20>");
        System.out.println(p1.toString());
        p1.add(13, 20);
        System.out.println(p1.toString());
    }
}
