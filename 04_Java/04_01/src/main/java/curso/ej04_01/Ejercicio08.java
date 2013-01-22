package curso.ej04_01;

public class Ejercicio08 {

    public static void main(String[] args) {
        // TODO 04.01.08
        /*
         * Cree un programa que indique si un nuúmero es primo o no.
         * Nota: Un número es primo si sus dos únicos divisores son él mismo y uno.
         */
        int primo = 2;
        boolean esPrimo = ((primo == 0) || (primo != 1) || (primo == 2)? false : true);
        
        for (int i = 2; i < primo; i++) {
            if (primo % i == 0) {
                esPrimo = false;
                break;
            }
        }
        
        System.out.println(primo + (esPrimo? " " : " no ") + "es primo");
    }
}
