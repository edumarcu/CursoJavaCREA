package curso.ej04_01;



public class Ejercicio05 {

    public static void main(String[] args) {
        // TODO 04.01.05
        /*
         * Cree un programa que imprima n números por pantalla (usando una instrucción for)
         * y que además indique si el número es par o impar.
         */
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                System.out.printf("%d es Par\n", i);
            } else {
                System.out.printf("%d es Impar\n", i);
            }
        }

        System.out.println("  ");

        for (int i = 0; i < 20; i++) {
            System.out.println( i + " es " + (i % 2 == 0 ? "par" : "impar"));
        }
    }
}
