package curso.ej05_01;

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
        
        int[][] v1 = new int[2][2];
        int[][] v2 = new int[2][2];
        
        v1[0][0] = 1;
        v1[0][1] = 2;
        v1[1][0] = 3;
        v1[1][1] = 4;
        
        v2[0][0] = 3;
        v2[0][1] = 7;
        v2[1][0] = 1;
        v2[1][1] = 4;
        
        int[][] v3 = new int[2][2];
        v3[0][0] = v1[0][0] + v2[0][0];
        v3[0][1] = v1[0][1] + v2[0][1];
        v3[1][0] = v1[1][0] + v2[1][0];
        v3[1][1] = v1[1][1] + v2[1][1];
        
        System.out.println("( " + v1[0][0] + ", " + v1[0][1] + " ) + "
                + " ( " + v2[0][1] + ", " + v2[0][1] + " ) = ( " + v3[0][0] + ", " + v3[0][1] + " )" );
        System.out.println("( " + v1[1][0] + ", " + v1[1][1] + " )   "
                + " ( " + v2[1][0] + ", " + v2[1][1] + " )   ( " + v3[1][0] + ", " + v3[1][1] + " )" );
        
    }
}
