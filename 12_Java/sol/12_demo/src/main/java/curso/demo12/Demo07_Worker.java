package curso.demo12;

import java.util.LinkedList;
import java.util.Queue;

public class Demo07_Worker {

    public static void main(String[] args) {
        WorkQueue queue = new WorkQueue();

        for (int i = 0; i < 10; i++) {
            queue.addWork(new DemoWorkUnit(i));
            System.out.println("Añadido trabajo " + i);
        }

        System.out.println("Añadidos trabajos");

    }


}

interface WorkUnit {
    void doWork();
}


class DemoWorkUnit implements WorkUnit {

    private int number;

    public DemoWorkUnit(int number) {
        this.number = number;
    }

    public void doWork() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Unit " + number);
        try { Thread.sleep(1000); } catch (Exception e) {}
    }
}

class WorkQueue implements Runnable {

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
