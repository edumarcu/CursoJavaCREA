package curso.demo06;

public class PerroSanBernardo extends Perro{
    
    public  PerroSanBernardo(String nombre) {
        super(nombre);
      //  System.out.println("Constructor PerroSanBernardo - nombre");
    }

    @Override
    public String ladrar() {
    //    System.out.println("Ladrar PerroSanBernardo");
        return "Ouf!";
    }
    
    public boolean tieneBarril() {
    //    System.out.println("TieneBarril PerroSanBernardo");
        return Math.random() > 0.5;
    }
    
}
