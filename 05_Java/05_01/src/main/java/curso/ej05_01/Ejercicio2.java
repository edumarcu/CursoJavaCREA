package curso.ej05_01;

public class Ejercicio2 {

    public static void main(String[] args) {
        // TODO 05.01.2
        /*
         * Escriba un programa que calcule la suma de los elementos de un vector
         * de enteros.
         *
         * {3,6,7} = 16
         */
        
        int[] v = {3, 6, 7};
        int suma = 0;
        
        for (int i = 0; i < v.length; i++) {
            suma += v[i];
        }
        
        System.out.println("{3, 6, 7} sumado = " + suma);
        
    }
}
