package curso.demo07.demo09;

public class Demo09 {

    public static void main(String[] args) {

        Ruidoso[] ruidosos = {
            new Perro("Mordisquitos"),
            new Coche()
        };

        for (Ruidoso ruidoso : ruidosos) {
            printRuidoso(ruidoso);
        }
    }

    public static void printRuidoso(Ruidoso a) {
        System.out.println("Un ruidoso hace " + a.hacerRuido());
    }
}
interface Ruidoso {
    String foo = "FOO";
    String hacerRuido();
}

abstract class Animal {

    private String especie;
    private String nombre;

    public Animal(String especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
}

class Perro extends Animal implements Ruidoso {

    public Perro(String nombre) {
        super("cánido", nombre);
    }

    @Override
    public String hacerRuido() {
        return "Guau Guau";
    }

    public String ladrar() {
        return hacerRuido();
    }
}

class Coche implements Ruidoso {
    public String hacerRuido() {
        return "Moooooc Moooc";
    }
}