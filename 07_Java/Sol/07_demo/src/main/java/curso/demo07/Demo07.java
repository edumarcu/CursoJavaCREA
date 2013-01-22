package curso.demo07;

public class Demo07 {

    public static void main(String[] args) {
//        Animal a = new Animal();
//        Animal a = new Mamifero();
        Perro p = new Perro("Thor");
        System.out.println(p.ladrar());

        Animal a = new Perro("Tobi");
        p = (Perro) a;
        System.out.println(p.ladrar());

        Animal[] animales = {
            new Perro("Mordisquitos"),
            new Gato("Calcetines"),
            new Vaca("Filomena")
        };

        for (Animal animal : animales) {
            printAnimal(animal);
        }
    }

    public static void printAnimal(Animal a) {
        System.out.println("El " + a.getEspecie() + " " + a.getNombre() + " hace " + a.hacerRuido());
    }
}


abstract class Animal {

    private String especie;
    private String nombre;

    public Animal(String especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }

    public abstract String hacerRuido();

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }
}
abstract class Mamifero extends Animal {
    public Mamifero(String especie, String nombre) {
        super(especie, nombre);
    }
}

class Perro extends Mamifero {

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


class Gato extends Animal {

    public Gato(String nombre) {
        super("felino", nombre);
    }

    public String hacerRuido() {
        return "Miau Miau";
    }
}

class Vaca extends Animal{

    public Vaca(String nombre) {
        super("vacuno", nombre);
    }


    public String hacerRuido() {
        return "Mooooo";
    }
}