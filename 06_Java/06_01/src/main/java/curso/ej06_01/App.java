package curso.ej06_01;

public class App {
    public static void main( String[] args ) {
        Point p1 = new Point(3,5);
        Point p2 = p1.clone();
        
        System.out.println("P1 ; P2");
        System.out.println(p1 + " ; " + p2);
        System.out.println();
        
        System.out.println("P1 == P2?");
        System.out.println(p1 == p2);
        System.out.println();
        
        System.out.println("P1 hashcode ; P2 hashcode");
        System.out.println(p1.hashCode() + " ; " + p2.hashCode());
        System.out.println();
        
        System.out.println("P1 equals P2?");
        System.out.println(p1.equals(p2));
        System.out.println();
        
        System.out.println("---> P1.X = 100");
        p1.setX(100);
        System.out.println();
        
        System.out.println("P1 ; P2");
        System.out.println(p1 + " ; " + p2);
        System.out.println();
        
        System.out.println("P1 == P2?");
        System.out.println(p1 == p2);
        System.out.println();
        
        System.out.println("P1 hashcode ; P2 hashcode");
        System.out.println(p1.hashCode() + " ; " + p2.hashCode());
        System.out.println();
        
        System.out.println("P1 equals P2?");
        System.out.println(p1.equals(p2));
        System.out.println();
    }
}
