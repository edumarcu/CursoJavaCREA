package curso.ej04_01;

public class Ejercicio09 {

    public static void main(String[] args) {
        // TODO 04.01.09
        /*
         * Cree un programa que calcule el factorial de un número.
         */
        int n = 17;
        long fact = 1;
        
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial de " + n + " es " + fact);
    }
}
