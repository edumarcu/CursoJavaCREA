package curso.demo06;

public class App {
    public static void main( String[] args ) {
        /* aplica en tiempo de ejecucion el metodo adecuado para el tio,
         * no ha variables
         */
        inspeccionarPerro(new Perro("Thor"));
        inspeccionarPerro(new PerroSanBernardo("Chiquitin"));
        inspeccionarPerro(new PerroChiuahuaTullido("Destructor"));
        
        System.out.println("");
        /* No aplica la funcion de SanBernardo pq es de tipo perro, 
         * tiempo de compilacion
         */
        Perro perro = new Perro("Thor");
        inspeccionarPerro(perro);
        
        
        perro = new PerroSanBernardo("Chiquitin");
        inspeccionarPerro(perro);
        
        perro = new PerroChiuahuaTullido("Destructor");
        inspeccionarPerro(perro); 
    }
    
    public static void inspeccionarPerro(Perro perro) {
        System.out.printf("%s tiene %d patas y hace %s\n",
                perro.getNombre(),
                perro.contarPatas(),
                perro.ladrar());
       
        /*
         * convertimos el perro en san bernardo para poder aplicar el metodo
         * excusivo de los san bernardos
         */
        if (perro instanceof PerroSanBernardo){
             PerroSanBernardo sanBernardo = (PerroSanBernardo) perro;
             System.out.println("\tTiene Barril: " + 
                     sanBernardo.tieneBarril());
        }
    }
    
    public static void inspeccionarPerro(PerroSanBernardo perro) {
        System.out.printf("%s tiene %d patas y hace %s\n",
                perro.getNombre(),
                perro.contarPatas(),
                perro.ladrar());
        
        System.out.println("\tTiene Barril: " + perro.tieneBarril());
    }
    
}
