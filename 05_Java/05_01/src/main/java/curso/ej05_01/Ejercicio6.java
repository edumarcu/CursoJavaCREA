package curso.ej05_01;

public class Ejercicio6 {

    public static void main(String[] args) {
        // TODO 05.01.6
        /*
         * Cree un programa que compare posición a posición dos vectores e
         * indique si son iguales.
         */
        
        int[] v1 = { 1, 2, 3};
        int[] v2 = { 1, 2, 4};
        boolean iguales = false;
        
        if (v1.length == v2.length) {
            int i = 0;
            iguales = v1[i] == v2[i];
            while (iguales && i < v1.length) {
                i++;
                iguales = v1[i] == v2[i];
            }
            
        }
        
        System.out.println((iguales ? "Si" : "No") + " son iguales");
        
    }
}
