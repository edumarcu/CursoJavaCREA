package curso.ej04_01;



public class Ejercicio10 {

    public static void main(String[] args) {
        // TODO 04.01.10
        /*
         * Cree un programa indique si un número es perfecto.
         * Nota: Un número es perfecto si la suma de sus divisores es igual al número.
         * El 6 y el 28 son números perfectos:
         *
         *  *  6 = 1 + 2 + 3
         *  *  28 = 1 + 2 + 4 + 7 + 14
         */

        for (int i = 1; i < 1000; i++) {
            if (perfect(i)) {
                System.out.println(i + " es Perfecto.");
            }
        }
    }

    public static boolean perfect(int n) {
        int addition = 0;
        for (int i = 1; i <= n / 2; i++) {
            if ( n % i == 0) {
                addition += i;
            }
        }

        return addition == n;
    }
}
