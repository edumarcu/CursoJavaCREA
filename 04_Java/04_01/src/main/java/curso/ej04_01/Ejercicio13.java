package curso.ej04_01;

public class Ejercicio13 {

    public static void main(String[] args) {
        // TODO 04.01.13
        /*
         * Cree un programa que dibuje un triángulo rectángulo de n columnas y m filas
         * con carácteres ’#’.
         *
         * n = 4, m = 3 imprime:
         *
         * #
         * ###
         * ####
         *
         * Nota: Para determinar la longitud de cada fila sólo hace falta una división y una multiplicación.
         */
        
        int n = 3;
        int m = 4;
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i <= ((float) n / (float) m) * j; i++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
