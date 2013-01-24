package curso.demo12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo04_Producer {

    public static void main(String[] args) {

        Queue queue = new LinkedList();

        Producer p = new Producer(queue);
        Consumer c = new Consumer(queue);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }

}

class Producer implements Runnable {
    private Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            int value = (int) Math.round(Math.random() * 10);

            synchronized(queue) {
                System.out.println("Produciendo: " + value);
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
                    System.out.println("Consumiendo: " + queue.poll());
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
