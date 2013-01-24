package curso.demo12;
public class Demo02 {

    public static void main(String[] args) throws InterruptedException {
        Thread t01 = new Thread01("Thread01");
        Thread t02 = new Thread(new Thread02(), "Thread02");

        // Daemon = true
        // JVM stops when all user threads have stopped
        t01.setDaemon(true);
        t02.setDaemon(true);

        t01.start();
        t02.start();

        System.out.println("Sleeep");
        Thread.currentThread().sleep(5000);

        // Wait to t01 to finish
        System.out.println("Waiting for threads to finish");
        t01.join();
        t02.join();


        System.out.println("Ya tá!");
    }
}


class Thread01 extends Thread {

    public Thread01(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + " " + i);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
    }
}

class Thread02 implements Runnable {
    @Override
    public void run() {
        Thread current = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            System.out.println(current.getName() + " " + i);
            try {
                current.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }
        }
    }
}