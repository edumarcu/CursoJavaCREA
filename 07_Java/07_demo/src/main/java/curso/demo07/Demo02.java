package curso.demo07;

public class Demo02 {
        
    public static Logger log = new Logger("Demo02");
    
    //static {
    //    i = 200;
    //    System.out.println("Reinicializo i a " + i);
    //}
    
    public static int i = 100;  //hasta aqui no ha inicializado la variable,
                                // por lo que no deja usarla en la de 200
    
    static {
        i = 300;
        System.out.println("Reinicializo i a " + i);
    }
    
    public static void main( String[] args ) {
        
        System.out.println("i = " + i);
        System.out.println();
        
        // carga la clase StaticLogger cuando la necesita, lo static tb
        System.out.println("Static looger: " + StaticLogger.log);
        System.out.println();
        
        System.out.println("Hija");
        new Hija();
    }
}

class Logger {
    
   public Logger(String name) {
       System.out.println("Logger: " + name);
   }
}

class StaticLogger {
   
    public static Logger log = new Logger("Static");
   
}

class Madre {
    public static Logger log = new Logger("Memoria static de Madre");
    public Madre() {
        System.out.println("Constructor Madre");
    }
}

class Hija extends Madre {
    public static Logger log = new Logger("Memoria static de Hija");
    public Hija() {
        System.out.println("Constructor Hija");
    }
}
