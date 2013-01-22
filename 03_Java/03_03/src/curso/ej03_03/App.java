package curso.ej03_03;


public class App {

    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point();
        
        //------------
        System.out.println("p.add(10,20)");
        p1.set(3, 5);
        System.out.println("p1 = " + p1.toString());
       
        p1.add(10, 20);
        System.out.println("p1 + (10,20) = " + p1.toString());
        System.out.println();
        
        //-----------
        System.out.println("Point.add(p1, 10, 20)");
        p1.set(3, 5);
        System.out.println("p1 = " + p1.toString());
       
        Point.add(p1, 10, 20);
        System.out.println("p1 + (10,20) = " + p1.toString());
        System.out.println();
        
        //----------
        System.out.println("Point.add(p1, p2)");
        p1.set(3, 5);
        System.out.println("p1 = " + p1.toString());
        p2.set(5, 8);
        System.out.println("p2 = " + p2.toString());
       
        System.out.println("p1 + p2 = " + Point.add(p1, p2).toString());
        System.out.println();
    }
}
