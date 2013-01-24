package curso.ej12_01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class R01Pasta implements Runnable {

    public void run() {

        System.out.println("Boiling Water");

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {        }

        System.out.println("Adding Salt");

        Thread t02 = new Thread(new R02Broth());
        t02.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {        }

        System.out.println("Boils Again");

        try {
            t02.join();
        } catch (InterruptedException ex) {
            System.out.println("Broth Not finished, won't taste the sane.");
        }

        System.out.println("Add Pasta");

        System.out.println("Waiting 10'");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {        }

        System.out.println("Pasta is Ready");
    }

}
