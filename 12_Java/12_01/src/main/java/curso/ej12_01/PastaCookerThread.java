package curso.ej12_01;

/**
 * Threads
 * @author EM
 */
public class PastaCookerThread implements Runnable  {
    @Override
    public void run() {
        System.out.println("\tWater boiling");
        System.out.println("\tSalting");
        Thread wst = new Thread(new WaterSpecierThread(), "WaterSpecierThread");
        wst.start();
        System.out.println("\tBoling again");
        try {
            wst.join();
        } catch (Exception e) {
        }
        System.out.println("\tPutting Pasta");
        System.out.print("\tCooking Pasta...");
        try {
            Thread.currentThread().sleep(1000);
        } catch (Exception e) {
        }
        System.out.println("OK!");
    }
}

