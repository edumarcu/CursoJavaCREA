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
        
        int n = 28;
        int sumaDivisores = 0;
        
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
               sumaDivisores += i; 
            }
        }
        
        if (n == sumaDivisores) {
            System.out.println(n + " es perfecto");
        }
        else {
            System.out.println(n + " no es perfecto");
        }
    }
}
