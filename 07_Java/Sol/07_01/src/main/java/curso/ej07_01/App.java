package curso.ej07_01;

import curso.ej07_01.ruido.Graznar;
import curso.ej07_01.ruido.HacerRuido;
import curso.ej07_01.ruido.Pitar;
import curso.ej07_01.volar.NoVuela;
import curso.ej07_01.volar.Volar;
import curso.ej07_01.volar.VolarConAlas;
import patos.Pato;

public class App {
    public static void main( String[] args ) {
        HacerRuido[] ruidos = {
            new Graznar(),
            new Pitar()
        };

        Volar[] vuelos = {
            new VolarConAlas(),
            new NoVuela()
        };

        Pato[] patos = new Pato[ruidos.length * vuelos.length];
        int i = 0;
        for (HacerRuido ruido : ruidos) {
            for (Volar vuelo: vuelos) {
                patos[i++] = new Pato(ruido, vuelo);
            }
        }

        for (i = 0; i < patos.length; i++) {
            System.out.println();
            System.out.println("Pato " + i);
            patos[i].volar();
            patos[i].hacerRuido();
        }
    }
}
