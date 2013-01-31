package curso.ej14_02;

import java.util.LinkedList;
import java.util.Queue;

public class WorkerQueue implements Runnable {

    private final Queue<WorkUnit> queue = new LinkedList<WorkUnit>();

    public WorkerQueue() {
        new Thread(this, "Queue1").start();
        new Thread(this, "Queue2").start();
        new Thread(this, "Queue3").start();
        new Thread(this, "Queue4").start();
    }

    public void addWork(WorkUnit unit) {
        synchronized(queue) {
            queue.add(unit);
            queue.notify();
        }
    }

    public void run() {
        WorkUnit unit;

        while (true) {
            synchronized(queue) {
                if (queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        continue;
                    }
                }
                unit = queue.poll();
            }

            try {
                unit.doWork(Thread.currentThread().getName());
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }

        }
    }
}

