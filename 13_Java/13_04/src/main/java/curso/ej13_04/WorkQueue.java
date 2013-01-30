package curso.ej13_04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Work Queue
 * @author EM
 */
public class WorkQueue implements Runnable {

    private Queue<WorkUnit> queue = new LinkedList<WorkUnit>();

    public WorkQueue() {
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
            unit.doWork();
        }
    }
}
