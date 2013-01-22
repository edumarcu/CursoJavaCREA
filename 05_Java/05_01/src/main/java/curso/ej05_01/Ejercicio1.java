package curso.ej05_01;

public class Ejercicio1 {

    public static void main(String[] args) {
        // TODO 05.01.1
        /*
         * Cree un programa que defina un vector de enteros con 40 posiciones.
         * Inicialice cada posición con el valor de su índice.
         * Imprima en pantalla el valor de cada posición.
         */
        int[] v = new int[40];
        
        for (int i = 0; i < 40; i++) {
            v[i] = i;
        }
        
        for (int i = 0; i < 40; i++) {
            System.out.println(" - " + v[i]);
        }
    }
}
