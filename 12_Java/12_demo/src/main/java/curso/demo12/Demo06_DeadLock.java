package curso.demo12;

/**
 * Threads, DeadLock
 * @author EM
 */
public class Demo06_DeadLock {

    public final static Object TOKEN1 = 'A';
    public final static Object TOKEN2 = 'B';

    public static void main(String[] args) {
        Thread t1 = new Thread(new Troll1(), "Troll1");
        Thread t2 = new Thread(new Troll2(), "Troll2");

        t1.start();
        t2.start();
    }
}

class Troll1 implements Runnable {

    public void run() {
        while (true) {
            synchronized (Demo06_DeadLock.TOKEN1) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }

                synchronized (Demo06_DeadLock.TOKEN2) {
                    System.out.println("Troll 1 - token2");
                }
            }

        }
    }
}

class Troll2 implements Runnable {

    public void run() {
        while (true) {
            synchronized (Demo06_DeadLock.TOKEN2) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                }

                synchronized (Demo06_DeadLock.TOKEN1) {
                    System.out.println("Troll2 - token1");
                }
            }

        }
    }
}

