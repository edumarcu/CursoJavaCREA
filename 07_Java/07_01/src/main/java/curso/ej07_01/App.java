package curso.ej07_01;

/**
 * Patos con interfaces
 * @author EM
 */
public class App {
    public static void main( String[] args ) {
        
        Pato patos[] = {new Pato(new VolarConAlas(), new Graznar()),
                    new Pato(new VolarConAlas(), new Pitar()),
                    new Pato(new NoVolar(), new Graznar()),
                    new Pato(new NoVolar(), new Pitar())};
        
        for (Pato pato : patos) {
            System.out.println(pato);
        }  
    }
    
}
