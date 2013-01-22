package curso.ej05_01;

import java.util.Arrays;

public class Ejercicio4 {

    public static void main(String[] args) {
        // TODO 05.01.4
        /*
         * Escriba un programa que calcule la suma de dos matrices 2x2
         * y muestre el resultado por pantalla.
         *
         * ( 1, 2 ) + ( 3, 7 ) = ( 4, 9 )
         * ( 3, 4 )   ( 1, 4 )   ( 4, 8 )
         */

        int[][] m1 = {  { 1, 2 },
                        { 3, 4 }};

        int[][] m2 = {  { 3, 7 },
                        { 1, 4 }};

        int[][] res = new int[2][2];

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }

        System.out.println("M1:      [" + Arrays.toString(m1[0]) + " " + Arrays.toString(m1[1]) + "]");
        System.out.println("M2:      [" + Arrays.toString(m2[0]) + " " + Arrays.toString(m2[1]) + "]");
        System.out.println("M1 + M2: [" + Arrays.toString(res[0]) + " " + Arrays.toString(res[1]) + "]");
    }
}
