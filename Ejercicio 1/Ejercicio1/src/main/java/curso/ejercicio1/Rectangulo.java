package curso.ejercicio1;

public class Rectangulo extends Figura{
    private int h;  /* lado horizontal */
    private int v;  /* lado vertical */
    
    public Rectangulo() {
    }
    
    public Rectangulo(int h, int v) {
        this.h = h;
        this.v = v;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getH() {
        return h;
    }

    public int getV() {
        return v;
    }
    
    
    @Override
    public double getArea() {
        return (h * v);
    }
    
    @Override
    public void print() {
        String s;
        
        s = "";
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < h; j++) {
                s += '#';
            }
            s += '\n';
        }
        System.out.println(s);
    }
    
    @Override
    public String toString() {
        String s;
        
        s = "Rectangulo " + h + "x" + v + "\n";
        s += "Area: " + getArea();
        
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangulo other = (Rectangulo) obj;
        if (this.h != other.h) {
            return false;
        }
        if (this.v != other.v) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 89 * hash + h;
        hash = 89 * hash + v;
        
        return hash;
    }
    
    @Override
    public Object clone() {
        Rectangulo r = new Rectangulo();
        
        r.h = this.h;
        r.v = this.v;
        
        return r;
    }    
}
