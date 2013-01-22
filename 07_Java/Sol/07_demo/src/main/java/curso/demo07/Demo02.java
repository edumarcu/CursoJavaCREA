package curso.demo07;


public class Demo02 {

    public static Logger log = new Logger("Demo02");

    public static int i = 100;

    static {
        i = 200;
        System.out.println("Reinicializo i a " + i);
    }

    static {
        i = 300;
        System.out.println("Reinicializo i a " + i);
    }


    public static void main(String[] args) {
        System.out.println("i = " + i);
        System.out.println("Static logger: " + StaticLogger.log);

        new Hija();
    }
}
class Logger {
    public Logger(String name) { System.out.println("Constructor: " + name); }
}

class StaticLogger {
    public static Logger log = new Logger("Static");
}

class Madre {
    public static Logger log = new Logger("Madre");
    public Madre() { System.out.println("Creando una Madre"); }
}

class Hija extends Madre {
    public static Logger log = new Logger("Hija");
    public Hija() { System.out.println("Creando una Hija"); }
}