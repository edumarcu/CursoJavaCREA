package curso.ej07_01;

/**
 * Patos con interfaces
 * @author EM
 */
public class Pato {
    
    private Volar volar;
    private HacerRuido ruido;
    
    public Pato(Volar volar, HacerRuido ruido) {
        this.volar = volar;
        this.ruido = ruido;
    }

    public String hacerRuido() {
        return ruido.hacerRuido();
    }

    public String volar() {
        return volar.volar();
    }

    @Override
    public String toString() {
        return "Soy un Pato y " + volar() +
                " y hago " + hacerRuido();
    }   
}
