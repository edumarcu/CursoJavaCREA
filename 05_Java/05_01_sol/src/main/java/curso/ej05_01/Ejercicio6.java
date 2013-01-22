package curso.ej05_01;

import java.util.Arrays;

public class Ejercicio6 {

    public static void main(String[] args) {
        // TODO 05.01.6
        /*
         * Cree un programa que compare posición a posición dos vectores e
         * indique si son iguales.
         */
        int[] array1 = {3, 6, 7};
        int[] array2 = {3, 6, 7};

        boolean equals = array1.length == array2.length;
        for (int i = 0; equals && i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                equals = false;
            }
        }

        System.out.println("Array1: " + Arrays.toString(array1));
        System.out.println("Array2: " + Arrays.toString(array2));

        if (equals) {
            System.out.println("Son iguales");
        } else {
            System.out.println("NO son iguales");
        }
    }
}
