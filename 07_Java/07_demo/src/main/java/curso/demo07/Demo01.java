package curso.demo07;

public class Demo01 {
    
    public static int numero = 0;
    
    public int numero2 = 13;
    
    public static void main( String[] args ) {
        
        System.out.println("Static");
        
        Demo01 d1 = new Demo01();
        d1.numero = 12;
        
        Demo01 d2 = new Demo01();
        d1.numero = 24;
        
        System.out.println("d1.numero " + d1.numero);
        System.out.println("d2.numero " + d2.numero);
        
        Demo01.numero = 36;
        System.out.println("Demo01.numero " + Demo01.numero);
        System.out.println("d1.numero " + d1.numero);
    
        System.out.println();
        
        System.out.println("Static Herencia");
        Demo01Child.printNumero();
        
        //numero2 = 45; --> no tiene sentido, metodo estatico
    }
    
    public static String foo() {
        return "FOO";
    }
}

class Demo01Child extends Demo01 {
    
   // public static int numero = 50; --> oculta la de la madre
    
    public static void printNumero() {
        System.out.println("Desde hija, Demo01.numero: " + Demo01.numero);
        System.out.println("Desde hija, Demo01Child.numero: " + Demo01Child.numero);
        
        System.out.println("Numero = 33");
        Demo01.numero = 33;
        
        System.out.println("Desde hija, Demo01.numero: " + Demo01.numero);
        System.out.println("Desde hija, Demo01Child.numero: " + Demo01Child.numero);
        System.out.println();
        
        System.out.println("FOO");
        System.out.println("FOO desde Madre " + Demo01.foo());
        System.out.println("FOO desde hija " + Demo01.foo() + Demo01Child.foo());
    }
    
    public static String foo() {
        return "BAR";
    }
}
