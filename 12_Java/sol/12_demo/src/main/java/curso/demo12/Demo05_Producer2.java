package curso.demo12;

import java.util.LinkedList;
import java.util.Queue;


public class Demo05_Producer2 {

    public static void main(String[] args) {

        Queue queue1 = new LinkedList();
        Queue queue2 = new LinkedList();

        Producer2 p1 = new Producer2(queue1, queue2);
        Consumer2 c1 = new Consumer2(queue1);
        Consumer2 c2 = new Consumer2(queue2);

        Thread t1 = new Thread(p1, "T-1");
        Thread t2 = new Thread(c1, "C-2");
        Thread t3 = new Thread(c2, "C-3");

        t1.start();
        t2.start();
        t3.start();
    }

}
class Producer2 implements Runnable {
    private Queue queue1;
    private Queue queue2;

    public Producer2(Queue queue1, Queue queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
    }

    public void run() {
        while (true) {
            int value = (int) Math.round(Math.random() * 10);

            synchronized(queue1) {
                synchronized(queue2) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " Produciendo: " + value);
                    queue1.add(value);
                    queue1.notify();
                    queue2.add(value);
                    queue2.notify();
                }
            }
            try {
                Thread.sleep(value * 10);
            } catch (InterruptedException ex) {
            }
        }
    }
}

class Consumer2 implements Runnable {
    private Queue queue;

    public Consumer2(Queue queue) {
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
