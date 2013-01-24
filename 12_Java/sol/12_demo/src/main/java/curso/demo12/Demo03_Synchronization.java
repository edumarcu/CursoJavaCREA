package curso.demo12;

public class Demo03_Synchronization {

    public static void main(String[] args) {

        Counter c1 = new Counter();
        Counter c2 = new Counter();

        Thread t1 = new Thread(new Incrementer(c1), "Thread-1");
        Thread t2 = new Thread(new Decrementer(c1), "Thread-2");

        Thread t3 = new Thread(new Incrementer(c2), "Thread-3 Counter2");
        Thread t4 = new Thread(new Decrementer(c2), "Thread-4 Counter2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Counter {
    private int counter = 0;

    public int incrementCounter() {
        synchronized(this) {
            int new_val = counter + 1;

            int countdown = (int) (Math.random() * 1000);
            try {
                Thread.sleep(countdown);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
            }

            counter = new_val;

            return counter;
        }
    }

    public int decrementCounter() {
        synchronized(this) {
            return --counter;
        }
    }
}

class Incrementer implements Runnable {

    private Counter counter;

    public Incrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = counter.incrementCounter();
            System.out.println(Thread.currentThread().getName() + ": " + value);
        }
    }
}

class Decrementer implements Runnable {

    private Counter counter;

    public Decrementer(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int value = counter.decrementCounter();
            System.out.println(Thread.currentThread().getName() + ": " + value);
        }
    }
}
