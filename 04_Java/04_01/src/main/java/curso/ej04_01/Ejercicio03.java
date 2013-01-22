package curso.ej04_01;

public class Ejercicio03 {

    public static void main(String[] args) {
        // TODO 04.01.03
        /*
         * Cree un programa que haga las siguientes operaciones, imprimiendo por
         * pantalla cada paso:
         *   * Creacioón de una variable c de tipo caracter.
         *   * Conversioón de “c” a tipo entero, guardando el valor en una variable i.
         *   * Creación de una variable l de tipo con valor superior a 50.000.
         *   * Conversión de la variable l a tipo byte.
         */
        char c = 'a';
        System.out.println("c = '" + c + "'");
        
        int i = (int) c;
        System.out.println("i = (int) c = " + i);
        
        int l = 50000;
        System.out.println("l = " + l);
        
        byte b = (byte)l;
        System.out.println("b = (byte) l = " + b);
        
    }
}
