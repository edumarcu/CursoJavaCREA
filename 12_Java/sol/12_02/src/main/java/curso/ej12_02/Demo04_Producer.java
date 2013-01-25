package curso.ej12_02;

import java.util.LinkedList;
import java.util.Queue;


public class Demo04_Producer {

    public static void main(String[] args) {

        Queue queue = new LinkedList();

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Consumer c = new Consumer(queue);

        Thread t1 = new Thread(p1, "T-1");
        Thread t2 = new Thread(p2, "T-2");
        Thread t3 = new Thread(p2, "T-3");
        Thread t4 = new Thread(c, "C-4");
        Thread t5 = new Thread(c, "C-5");
        Thread t6 = new Thread(c, "C-6");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }

}
class Producer implements Runnable {
    private Queue queue;

    private int counter = 0;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            int value = (int) Math.round(Math.random() * 10);

            synchronized(queue) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " Produciendo: " + value);
                System.out.println("Counter: " + ++counter);
                queue.add(value);
                queue.notify();
            }
            try {
                Thread.sleep(value * 10);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Consumer implements Runnable {
    private Queue queue;

    public Consumer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            synchronized(queue) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        continue;
                    }
                }

                while (!queue.isEmpty()) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " Consumiendo: " + queue.poll());
                }
            }
/*
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
            }
            */
        }
    }
}
