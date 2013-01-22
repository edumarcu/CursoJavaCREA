package curso.ej03_04;

public class Point {
    private int x = 10;
    private int y;
     
    public Point() {
        this(13,14);
        System.out.println("Constructor defecto: " + this.toString());
    }
    
    public Point(int x, int y) {
        //this();
        System.out.println("Constructor parametros - 1ªlinea: " + this.toString());
        set(x,y);
        System.out.println("Constructor parametros - ultima linea: " + this.toString());
    }
    
    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }
    
    public static void add(Point p, int x, int y) {
        p.x += x;
        p.y += y;
    }
    
    public static Point add(Point p1, Point p2) {
        Point p = new Point();
        
        p.x = p1.x + p2.x;
        p.y = p1.y + p2.y;
        
        return (p);
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
        return(x);
    }
    
    public int getY() {
        return(y);
    }
    
    public String toString() {
        return String.format("(%d,%d)",this.x,this.y);
    }
}
