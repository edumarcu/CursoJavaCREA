package curso.ej12_01;

/**
 * Threads
 * @author EM
 */
public class BolognesaSauceCooker implements Runnable {
    @Override
    public void run() {
        System.out.println("\tCooking Onnion");
        System.out.println("\tCooking Meat");
        System.out.println("\tPutting Tomato");
        System.out.println("\tPutting Species");
    }
}
