package curso.ej04_01;



public class Ejercicio06 {

    public static void main(String[] args) {
        // TODO 04.01.06
        /*
         * Cree un programa que imprima por pantalla los divisores de un número.
         * Nota: El resto de dividir un número por uno de sus divisores es 0.
         */
        int n = 68;
        for (int i = 1; i <= n/2; i++) {
            if (n % i == 0) {
                System.out.println( i + " es divisor de " + n);
            }
            System.out.println( n + " es divisor de " + n);
        }
    }
}
