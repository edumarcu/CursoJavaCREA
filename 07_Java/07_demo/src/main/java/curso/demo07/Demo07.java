package curso.demo07;

/**
 *
 * @author EM, sin acabar
 */
public class Demo07 {

    public static void main(String[] args) {
      //  Animal a = new Animal(); // no se puedeninstancias obj de class abtractas
      //   Animal a = new Mamifero();
        Animal p = new Perro("Thor");
        System.out.println(p.hacerRuido());
        
        Animal a = new Perro("Tobi");
        p = (Perro) a;
        System.out.println(p.hacerRuido());
    }
}

// decimos que no esta implementado del todo con abstract, simepre al principio
abstract class Animal {
    protected String especie;
    protected String nombre;

    public Animal() {
    }
    
    public Animal(String especie, String nombre) {
        this.especie = especie;
        this.nombre = nombre;
    }
   
    public abstract String hacerRuido();
    
    public String getNombre() {
        return nombre;
    }
}
abstract class Mamifero extends Animal {
    
    // si no implementamos hacerRuido() sigue siendo abstracta, hay que marcarlo
}


class Perro extends Animal {

    public Perro(String nombre) {
        super("canido", nombre);
    }

    @Override
    public String hacerRuido() {
        return nombre + " hace: Guau!";
    }
}


class Gato extends Animal {

    public Gato(String nombre) {
        super("felino", nombre);
    }
    
    @Override
    public String hacerRuido() {
        return nombre+ " hace: Miau!";
    }
}

class Vaca extends Animal {

    public Vaca(String nombre) {
        super("vacuno", nombre);
    }
    
    @Override
    public String hacerRuido() {
        return nombre + " hace: Muuu!";
    }
}