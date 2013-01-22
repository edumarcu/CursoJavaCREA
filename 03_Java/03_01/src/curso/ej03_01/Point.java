package curso.ej03_01;

public class Point {
    private int x;
    private int y;
        
    public void set (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX (int x) {
        this.x = x;
    }
    
    public void setY (int y) {
        this.y = y;
    }
    
    public int getX () {
        return(x);
    }
    
    public int getY () {
        return(y);
    }
    
    public String toString() {
        return String.format("(%d,%d)",this.x,this.y);
    }
}
