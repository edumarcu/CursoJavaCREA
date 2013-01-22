package curso.ej04_01;



public class Ejercicio07 {

    public static void main(String[] args) {
        // TODO 04.01.07
        /*
         * Cree un programa que calcule la potencia n de un número a.
         * Nota: Por esta vez lo realizaremos multiplicando n veces.
         */
        int a = 2;
        int n = 8;
        int r = 1;
        for (int i = 0; i < n; i++) {
            r *= a;
        }

        System.out.printf("%d ^ %d = %d\n", a, n, r);


        r = (int) Math.pow(a, n);
        System.out.printf("%d ^ %d = %d\n", a, n, r);
    }
}
