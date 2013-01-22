package curso.ej03_04;

public class App {

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 8);

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
