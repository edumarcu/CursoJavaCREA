package curso.ej04_01;

public class Ejercicio07 {

    public static void main(String[] args) {
        // TODO 04.01.07
        /*
         * Cree un programa que calcule la potencia n de un número a.
         * Nota: Por esta vez lo realizaremos multiplicando n veces.
         */
        
        int a = 2;
        int n = 10;
        int a_n = 1;
        
        System.out.print(a + " a la " + n + " = " );
        for (int i = 0; i < n; i++) {
            a_n *= a;
        }
        System.out.println(a_n);
        
        a_n = (int) Math.pow(a,n);
        System.out.println(a + " a la " + n + " = " + a_n);
    }
}
