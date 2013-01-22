package curso.demo06;

public class PerroChiguaguaTullido extends Perro {

    public PerroChiguaguaTullido(String nombre) {
        super(nombre);
    }

    @Override
    public String ladrar() {
        return "Grrrrr!";
    }

    @Override
    public int contarPatas() {
        return super.contarPatas() - 1;
    }

    public static void main(String[] args) {
        Perro p = new Perro("Tobi");

//        p.nombre = "";
        p.a = 0;
        p.b = 0;
        p.c = 0;
    }

}
