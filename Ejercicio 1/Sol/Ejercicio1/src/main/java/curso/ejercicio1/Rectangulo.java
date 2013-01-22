package curso.ejercicio1;

import java.io.PrintStream;

public class Rectangulo extends Figura{

    private int base;
    private int altura;

    public Rectangulo(int base, int altura) {
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
            for (int j = 0; j < base; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return base * altura;
    }

    @Override
    public String toString() {
        return "Rectangulo " + base + "x" + altura;
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
        if (!(obj instanceof Rectangulo)) {
            return false;
        }
        final Rectangulo other = (Rectangulo) obj;
        if (this.base != other.base) {
            return false;
        }
        if (this.altura != other.altura) {
            return false;
        }
        return true;
    }

    @Override
    protected Rectangulo clone() {
        return new Rectangulo(this.base, this.altura);
    }
}
