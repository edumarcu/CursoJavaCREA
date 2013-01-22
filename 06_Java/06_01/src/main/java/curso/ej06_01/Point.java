package curso.ej06_01;

public class Point {
    private int x = 10;
    private int y;
     
    public Point() {
    }
    
    public Point(int x, int y) {
        set(x,y);
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

    @Override
    protected Point clone() {
        Point p = new Point();
        
        p.x = this.x;
        p.y = this.y;
        
        return p;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.x;
        hash = 29 * hash + this.y;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
    
    
}
