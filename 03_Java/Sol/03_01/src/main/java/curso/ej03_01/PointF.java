package curso.ej03_01;



public class PointF {

    private float x;

    private float y;

    public void set(float x, float y) {
        setX(x);
        setY(y);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("<%.2f,%.2f>", x, y);
    }
}
