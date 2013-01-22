package curso.ej05_01;

import java.util.Arrays;

public class Ejercicio5 {

    public static void main(String[] args) {
        // TODO 05.01.5
        /*
         * Escribe un programa que copie un vector posición a posición en otro
         * de igual tamaño.
         */
        int[] array = {3, 6 ,7};
        int[] copy = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Copy : " + Arrays.toString(copy));

        System.out.println();
        System.out.println("Array: " + Arrays.toString(array));
        copy = Arrays.copyOf(array, array.length);
        System.out.println("Copy : " + Arrays.toString(copy));
    }
}
