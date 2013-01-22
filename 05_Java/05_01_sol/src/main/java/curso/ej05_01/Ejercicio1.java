package curso.ej05_01;

public class Ejercicio1 {

    public static void main(String[] args) {
        // TODO 05.01.1
        /*
         * Cree un programa que defina un vector de enteros con 40 posiciones.
         * Inicialice cada posición con el valor de su índice.
         * Imprima en pantalla el valor de cada posición.
         */

        int n = 40;
        int[] array = new int[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        for (int i : array) {
            System.out.println(" " + i);
        }
    }
}
