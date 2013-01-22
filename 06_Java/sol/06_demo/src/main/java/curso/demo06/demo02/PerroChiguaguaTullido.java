package curso.demo06.demo02;

import curso.demo06.*;

public class PerroChiguaguaTullido extends Perro {

    public PerroChiguaguaTullido(String nombre) {
        super(nombre);
//        this.nombre = "foo";
        this.a = 0;
//        this.b = 0;
        this.c = 0;
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
//        p.a = 0;
//        p.b = 0;
        p.c = 0;
    }

}
