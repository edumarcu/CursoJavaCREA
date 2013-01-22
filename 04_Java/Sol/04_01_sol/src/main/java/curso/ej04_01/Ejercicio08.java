package curso.ej04_01;



public class Ejercicio08 {

    public static void main(String[] args) {
        // TODO 04.01.08
        /*
         * Cree un programa que indique si un número es primo o no.
         * Nota: Un número es primo si sus dos únicos divisores son él mismo y uno.
         */

        for (int i = 0; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + " es Primo");
            }
        }
    }

    public static boolean isPrime(int n) {
        if ( n <= 0) {
            return false;
        }

        if ( n <= 2 ) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        int sqrt = (int) Math.round(Math.sqrt(n));
        for (int i = 3; i <= sqrt; i += 2) {
            if ( n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
