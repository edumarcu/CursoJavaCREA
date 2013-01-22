package curso.ej04_01;



public class Ejercicio13 {

    public static void main(String[] args) {
        // TODO 04.01.13
        /*
         * Cree un programa que dibuje un triángulo rectángulo de n filas y m columnas
         * con carácteres ’#’.
         *
         * n = 4, m = 3 imprime:
         *
         * #
         * #
         * ##
         * ###
         *
         * Nota: Para determinar la longitud de cada fila sólo hace falta una división y una multiplicación.
         */
        int n = 20;
        int m = 30;
        for (int i = 0; i < n; i++) {

            int lenght = i * m / n;

            for (int j = 0; j <= lenght; j++) {
                System.out.print("#");
            }

            System.out.println();
        }
    }
}
