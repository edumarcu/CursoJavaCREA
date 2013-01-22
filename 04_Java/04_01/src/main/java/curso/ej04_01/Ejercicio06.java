package curso.ej04_01;

public class Ejercicio06 {

    public static void main(String[] args) {
        // TODO 04.01.06
        /*
         * Cree un programa que imprima por pantalla los divisores de un número.
         * Nota: El resto de dividir un número por uno de sus divisores es 0.
         */
        int i = 1;
        int n = 20;
        
        System.out.println("Divisores de " + n);
        while (i <= n) {
            if (n % i == 0) {
                System.out.println(" - " + i);
            }
            i++;
        }
    }
}
