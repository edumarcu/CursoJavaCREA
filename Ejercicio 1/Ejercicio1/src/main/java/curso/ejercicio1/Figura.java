package curso.ejercicio1;

public class Figura implements Cloneable {
    
    public double getArea() {
         return 0.0;
    }
    
    public void print(){
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    } 
}
