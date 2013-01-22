package curso.ejercicio1;

public class Cuadrado extends Rectangulo{

    public Cuadrado(int lado) {
        super(lado, lado);
    }

    public int getLado() {
        return super.getAltura();
    }

    public void setLado(int lado) {
        super.setBase(lado);
        super.setAltura(lado);
    }

    @Override
    public String toString() {
        return "Cuadrado lado " + getLado();
    }

    @Override
    protected Cuadrado clone() {
        return new Cuadrado(getLado());
    }
}
