package curso.ej12_01;

/**
 * Threads, Pasta a la boloñesa
 * @Author EM
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("Welcome to Pasta Bolognesa!");
        System.out.println();

        System.out.println("Pasta cooking...");
        Thread pct = new Thread(new PastaCookerThread(), "");
        pct.start();

        System.out.println("Bolognesa sauce cooking...");
        Thread bsc = new Thread(new BolognesaSauceCooker(), "");
        bsc.start();

        System.out.println("Telling Jokes");
        JokesTeller j = new JokesTeller();
        Thread jt = new Thread(j, "");
        jt.start();

        try {
            pct.join();
        } catch (Exception e) {
        }
        System.out.println("OK! (Pasta)");

        try {
            bsc.join();
        } catch (Exception e) {
        }
        System.out.println("OK! (Sauce)");

        j.tellJokes = false;
        System.out.println("OK! (Jokes)");

        System.out.println();
        System.out.println("Pasta Bolognesa is ready, enjoy!");
    }
}
