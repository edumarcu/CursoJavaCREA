package curso.ej04_01;

public class Ejercicio12 {

    public static void main(String[] args) {
        // TODO 04.01.12
        /*
         * Cree un programa que dibuje un rectángulo de n columnas y m filas
         * con carácteres ’#’.
         *
         * n = 5, m = 3 imprime:
         *
         * #####
         * #####
         * #####
         */
        
        int n = 5;
        int m = 3;
        
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                System.out.print("#");
            }
            System.out.println("");
        }
    }
}
