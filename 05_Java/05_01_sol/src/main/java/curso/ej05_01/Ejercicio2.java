package curso.ej05_01;

import java.util.Arrays;

public class Ejercicio2 {

    public static void main(String[] args) {
        // TODO 05.01.2
        /*
         * Escriba un programa que calcule la suma de los elementos de un vector
         * de enteros.
         *
         * {3,6,7} = 16
         */

        int[] array = { 3, 6, 7 };
        int result = 0;
        for (int i : array) {
            result += i;
        }

        System.out.println("La suma del array: " + Arrays.toString(array));
        System.out.println("Es: " + result);
    }
}
