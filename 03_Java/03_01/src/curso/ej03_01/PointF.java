package curso.ej03_01;

public class PointF {
    private float x;
    private float y;
    
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
    
    public float getX () {
        return(x);
    }
    
    public float getY () {
        return(y);
    }
    
    public String toString() {
        return String.format("%.1f,%.1f",this.x,this.y);
    }
}
