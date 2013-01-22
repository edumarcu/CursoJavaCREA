package curso.ej05_01;

public class Ejercicio5 {

    public static void main(String[] args) {
        // TODO 05.01.5
        /*
         * Escribe un programa que copie un vector posición a posición en otro
         * de igual tamaño.
         */
        
        int[] v1 = { 1, 2, 3};
        int[] v2 = new int[3];
        
        System.out.print("v1[");
        for (int i : v1) {
           System.out.print(i);
            if (i != v1[v1.length - 1]) {
                System.out.print(", "); 
            }
        }
        System.out.println("]");
        
        for (int i = 0; i < v1.length; i++) {
            v2[i] = v1[i];
        }
        
        System.out.print("v2[");
        for (int i : v2) {
           System.out.print(i);
            if (i != v2[v2.length - 1]) {
                System.out.print(", "); 
            }
        }
        System.out.println("]");
    }
}
