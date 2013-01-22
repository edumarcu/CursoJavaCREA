package curso.demo06;

public class Perro {

    private String nombre;

    protected int a;
    int b;
    public int c;

    public Perro(String nombre) {
        this.nombre = nombre;
    }

    public int contarPatas() {
        return 4;
    }

    public String ladrar() {
        return "Guau!";
    }

    public String getNombre() {
        return nombre;
    }

}
