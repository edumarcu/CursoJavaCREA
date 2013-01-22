package curso.ej06_01;

public class App
{
    public static void main( String[] args ) throws CloneNotSupportedException
    {
        Point p1 = new Point(3, 5);
        Point p2 = (Point) p1.clone();

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);
        System.out.println();

        System.out.println("P1 == P2: " + (p1 == p2) );

        System.out.println("P1 hash: " + p1.hashCode());
        System.out.println("P2 hash: " + p2.hashCode());

        System.out.println("P1 equals P2: " + p1.equals(p2) );

        System.out.println();
        p1.setX(100);
        System.out.println("P1.x = 100");
        System.out.println();

        System.out.println("P1: " + p1);
        System.out.println("P2: " + p2);

        System.out.println("P1 == P2: " + (p1 == p2) );

        System.out.println("P1 hash: " + p1.hashCode());
        System.out.println("P2 hash: " + p2.hashCode());

        System.out.println("P1 equals P2: " + p1.equals(p2) );

    }
}
