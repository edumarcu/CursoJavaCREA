package curso.ejercicio1;

public class Cuadrado extends Rectangulo {
    
    public Cuadrado() {
        super();
    }
    
    public Cuadrado(int lado) {
        super(lado, lado);
    }

    public void setLado(int lado) {
        setH(lado);
        setV(lado);
    }

    public int getLado() {
        return getH();
    }
    
    /* Sobreescribo para que no pueda tener distinta h y v */
    @Override
    public void setH(int h) {
    }

    @Override
    public void setV(int v) {
    }
    
    @Override
    public double getArea() {
        return super.getArea();
    }
    
    @Override
    public void print() {
        super.print();
    }
    
    @Override
    public String toString() {
        String s;
        
        s = "Cuadrado lado " + getLado() + "\n";
        s += "Area: " + getArea();
        
        return s;
    }

   @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

   @Override
    public int hashCode() {
        int hash = 3;
        
        hash = 67 * hash + getH();
        
        return hash;
    }

    @Override
    public Object clone() {
        return super.clone();
    }

}
