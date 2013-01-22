package curso.demo07;

/**
 * Clases inner
 * @author EM
 */
public class Demo12 {
    // es una clase hija de Comparador, definida en Demo 12, es anonima
    static Comparador c = new Comparador() {
        @Override
        public boolean mayorQue(int a, int b) {
            return ((a - b) > 0);
        } 
    }; // OJO al ;
    
    // Equivale a
/*    static class ComparadorAnonimo extends Comparador {
        @Override
        public boolean mayorQue(int a, int b) {
            return ((a - b) > 0);
        } 
    }
*/
    
    public static void main(String[] args) {
     //   Comparador c = new Comparador();
        Comparador c2 = new Comparador() {
            public boolean mayorQue(int a, int b) {
                return (a > b);
            }
        };
        
        System.out.println("Subclase 3 > 5? : " + c.mayorQue(3, 5));
        System.out.println("Interface 3 > 5? : " + c2.mayorQue(3, 5));
    }
    
}

// mejor hacerlo con interfaces
interface Comparador {
    public boolean mayorQue(int a, int b);
}

/*
class Comparador {
    public boolean mayorQue(int a, int b) {
        return (a > b);
    }
}
*/
