package patos;

import curso.ej07_01.ruido.HacerRuido;
import curso.ej07_01.volar.Volar;

public class Pato {

    private HacerRuido ruido;

    private Volar volar;

    public Pato(HacerRuido ruido, Volar volar) {
        this.ruido = ruido;
        this.volar = volar;
    }

    public void volar() {
        volar.volar();
    }

    public void hacerRuido() {
        ruido.hacerRuido();
    }
}
