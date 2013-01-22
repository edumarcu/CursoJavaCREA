package curso.ejercicio1;

public class Triangulo extends Rectangulo {
    
    public Triangulo() {
        super();
    }
    
    public Triangulo(int h, int v) {
        super(h, v);
    }
    
    @Override
    public double getArea() {
        return (getH() * getV() / 2);
    }
    
    @Override
    public void print() {
        String s = "";
        int h = getH();
        int v = getV();
       
        for (int i = 0; i < v; i++) {
            int lenght = i * h / v;
            
            for (int j = 0; j <= lenght; j++) {
                s += '#';
            }
            s += '\n';
        }
        System.out.println(s);
    }
    
    @Override
    public String toString() {
        String s;
        
        s = "Triangulo " + getH() + "x" + getV() + "\n";
        s += "Area: " + getArea();
        
        return s;
    }
}
