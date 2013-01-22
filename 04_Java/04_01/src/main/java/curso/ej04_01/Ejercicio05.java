package curso.ej04_01;

public class Ejercicio05 {

    public static void main(String[] args) {
        // TODO 04.01.05
        /*
         * Cree un programa que imprima n números por pantalla (usando una instrucción for)
         * y que además indique si el número es par o impar.
         */
        for (int i = 0; i < 10; i++) {
            System.out.print(" - " + i);
            if (i % 2 == 0) {
                System.out.println(" es par");
            }
            else {
                System.out.println(" es impar");
            }
                
        }
    }
}
