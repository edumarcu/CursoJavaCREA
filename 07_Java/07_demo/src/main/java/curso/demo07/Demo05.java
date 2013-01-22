package curso.demo07;

public class Demo05 {
    
    public static void main(String[] args) {
        
        System.out.println("Varargs");
     //   imprimir(1, 2, 3, 4 ,5); //-> duda si hacer autoboxing o no
     //   imprimir();
        imprimir(new int[]{6, 7 ,8}); // este es el unico que no es ambiguo
                                       // decimos el timpo concreto que queremos
        imprimir(new Integer[]{6, 7 ,8});
    }
    
    // internamente el compilador convierte a un array de int
    public static void imprimir(int... numeros) {
        System.out.println("Imprimir int...");
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
        System.out.println();   
    }
    
    public static void imprimir(Integer... numeros) {
        System.out.println("Imprimir Integer... ");
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
        System.out.println();   
    }
    
    /*
    public static void imprimir(int numero, int... numeros) {
        System.out.println("Imprimir int: " + numero);
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
        
    }
    */
    
    /*
     * a este metodo nunca lo llamria, el compilador elegiria la que antes 
     * cumple los parametros, en este caso la anterior
     */
    /*
    public static void imprimir(Integer numero, int... numeros) {
        System.out.println("Imprimir Integer: " + numero);
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
        
    }
    */
}
