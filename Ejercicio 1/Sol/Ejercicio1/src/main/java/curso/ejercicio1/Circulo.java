package curso.ejercicio1;

import java.io.PrintStream;

public class Circulo extends Figura{

    private int radio;

    public Circulo(int radio) {
        this.radio = radio;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public void pinta(PrintStream out) {
        for (int x = -radio; x <= radio; x++) {
            for (int y = -radio; y <= radio; y++) {
//                if (Math.round(Math.sqrt((x * x) + (y * y))) <= radio) {
                if ((x * x) + (y * y) <= (radio * radio)) {
                    System.out.print("# ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public String toString() {
        return "Círculo r" + radio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.radio;
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
        final Circulo other = (Circulo) obj;
        if (this.radio != other.radio) {
            return false;
        }
        return true;
    }

    @Override
    protected Circulo clone() {
        return new Circulo(this.radio);
    }
}
