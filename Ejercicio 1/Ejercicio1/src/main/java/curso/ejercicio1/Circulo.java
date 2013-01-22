package curso.ejercicio1;

public class Circulo extends Cuadrado {
    
    public Circulo() {
        super();
    }
    
    public Circulo(int radio) {
        super(radio);
    }
    
    public void setRadio(int radio) {
        super.setLado(radio);
    }

    public int getRadio() {
        return super.getLado();
    }
    
    @Override
    public double getArea() {
        return (2 * Math.PI * getLado());
    }
    
    @Override
    public String toString() {
        String s;
        
        s = "Circulo r" + getRadio() + "\n";
        s += "Area: " + getArea();
        
        return s;
    }
    
    @Override
    public void print() {
        String s;
        int r = getRadio();
        
        s = "";
        for (int i = 1; i <= r / 2; i++) {
            for (int j = 1; j <= r / 2; j++) {
                if ( i % j == 0)
                    s += '#';
            }
            s += '\n';
        }
        System.out.println(s);
    }
}
