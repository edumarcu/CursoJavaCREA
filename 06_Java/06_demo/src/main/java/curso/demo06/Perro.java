package curso.demo06;

public class Perro {
    private String nombre;

    public Perro() {
        System.out.println("Constructor Perro - no param");
    }
    
    public  Perro(String nombre) {
        this.nombre = nombre;
    //    System.out.println("Constructor Perro - nombre");
    }
    
    public int contarPatas() {
    //    System.out.println("ContarPatas Perro");
        return 4;
    }
    
    public String ladrar() {
    //    System.out.println("Ladrar Perro");
        return "guau!";
    }

    public String getNombre() {
     //   System.out.println("GetNombre Perro");
        return nombre;
    }
    
    
}
