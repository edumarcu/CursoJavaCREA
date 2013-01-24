package curso.ej12_01;

/**
 * Threads
 * @author EM
 */
public class WaterSpecierThread implements Runnable {
    @Override
    public void run() {
        System.out.println("\tPutting Avecrem");
        System.out.println("\tPutting Laurel");
        System.out.println("\tPutting Oil");
    }
}
