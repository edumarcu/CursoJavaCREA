package curso.demo07;

public class Demo06 {
    
    public static void main(String[] args) {
        
        System.out.println("Varargs Clases");
        A a1 = new A();
        A a2 = new A();
        B b1 = new B();
        A a3 = b1;
        
        imprimir(a1, a2, b1, a3); // funciona tb el polimorfismo
        imprimir(new A[]{a1, a2, b1, a3});
        
        imprimir(b1, a1, a2, a3);
        
    }
   
    public static void imprimir(A... objs) {
        System.out.println("Imprimir A...");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
        System.out.println();   
    }
    /* colisiona con la arriba 
    public static void imprimir(A obj, A... objs) {
        System.out.println("Imprimir A obj");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
        System.out.println();   
    }
    */
    // si comentaramos este, en el de b1 el 1o llamaria a A...
    public static void imprimir(B obj, A... objs) {
        System.out.println("Imprimir B obj");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
        System.out.println();   
    } 
    
    // probar con tipos basicos, int byte long...
    
}

class A {
    
}

class B extends A {
    
}
