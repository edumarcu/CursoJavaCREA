package curso.ej05_01;

import java.util.Arrays;

public class Ejercicio3 {

    public static void main(String[] args) {
        // TODO 05.01.3
        /*
         * Escriba un programa que indique si un número es capicúa.
         * Almacene inicialmente el número en un vector de enteros.
         *
         * Para el 45.654:
         * {4,5,6,5,4} = true
         */
//        int[] number = {4, 5, 6, 5, 4};
        int n = 45654;
        int[] number = numberToArray(n);

        System.out.println("Número: " + n);
        System.out.println("Array:  " + Arrays.toString(number));

        int digits = number.length;
        boolean palindromic = true;
        for (int i = 0; i < (digits / 2); i++) {
            if (number[i] != number[digits - i - 1]) {
                palindromic = false;
                break;
            }
        }

        if (palindromic) {
            System.out.println("Es capicúa.");
        } else {
            System.out.println("NO es capicúa.");
        }

    }

    public static int[] numberToArray(int number){
        int digits = (int) Math.ceil(Math.log10(number));
        int[] array = new int[digits];

        int lastdigit = 0;
        int remainingdigits = number;
        for (int i = 0; i < digits; i++) {
            int multiplier = (int) Math.pow(10, digits - i - 1);
            int digit = remainingdigits / multiplier;

            array[i] = digit;

            remainingdigits -= digit * multiplier;
        }

        return array;
    }
}
