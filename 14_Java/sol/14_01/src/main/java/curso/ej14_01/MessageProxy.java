package curso.ej14_01;

import java.util.LinkedList;
import java.util.List;

public final class MessageProxy {

    // Singleton

    public final static MessageProxy instance = new MessageProxy();

    private MessageProxy() {}

    // Implementation

    List<MessageObserver> observers = new LinkedList<MessageObserver>();

    synchronized void registerObserver(MessageObserver observer) {
        observers.add(observer);
    }

    synchronized void removeObserver(MessageObserver observer) {
        observers.remove(observer);
    }

    synchronized void notifyObservers(final String sender, final String message) {
        for (final MessageObserver observer : observers) {
//            observer.messageReceived(sender, message);
            Server.queue.addWork(new WorkUnit() {
                public void doWork() throws Exception {
                    observer.messageReceived(sender, message);
                }
            });
        }
    }
}
