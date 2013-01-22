package curso.ejercicio1;

import java.io.PrintStream;

public class Triangulo extends Figura{

    private int base;
    private int altura;

    public Triangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }


    @Override
    public void pinta(PrintStream out) {
        for (int i = 0; i < altura; i++) {
            int distancia = i * base / altura;
            for (int j = 0; j <= distancia; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return base * altura / 2;
    }

    @Override
    public String toString() {
        return "Triángulo " + base + "x" + altura;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.base;
        hash = 59 * hash + this.altura;
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
        final Triangulo other = (Triangulo) obj;
        if (this.base != other.base) {
            return false;
        }
        if (this.altura != other.altura) {
            return false;
        }
        return true;
    }

    @Override
    protected Triangulo clone() {
        return new Triangulo(this.base, this.altura);
    }
}
