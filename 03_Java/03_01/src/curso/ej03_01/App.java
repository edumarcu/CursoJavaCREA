package curso.ej03_01;

public class App {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Point p1, p2;
        p1 = new Point();
        p2 = new Point();
        
        PointF pF1, pF2;
        pF1 = new PointF();
        pF2 = new PointF();
        
        /*
        p1.x = 3; p1.y = 5;
        p2.x = 10; p2.y = 13;
        pF1.x = 3; pF1.y = 5;
        pF2.x = 10; pF2.y = 13;*/
        
        p1.set (3,5);
        p2.setX(10); p2.setY(13);
        
        pF1.set (3,5);
        pF2.setX(10); pF2.setY(13);
        
        /*
        System.out.println("Puntos enteros");
        System.out.println("P1 (" + p1.x + "," + p1.y +")");
        System.out.println("P2 (" + p2.x + "," + p2.y +")");
        
        System.out.println("Puntos flotantes");
        System.out.println("PF1 (" + pF1.x + "," + pF1.y +")");
        System.out.println("PF2 (" + pF2.x + "," + pF2.y +")");*/
        
        System.out.println("P1= " + p1.toString());
        System.out.println("P2= (" + p2.getX() + "," + p2.getY() +")");
        
        System.out.println("PF1= " + pF1.toString());
        System.out.println("PF2= (" + pF2.getX() + "," + pF2.getY() +")");
        
        
    }
    
   
}
