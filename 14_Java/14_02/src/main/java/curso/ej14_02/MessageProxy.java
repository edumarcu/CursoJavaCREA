package curso.ej14_02;

import java.util.LinkedList;
import java.util.List;

/**
 * Proxy for Observers, Massage sender receiver
 * @author EM
 */
public final class MessageProxy {

    private static final List<MessageObserver> observers = new LinkedList<MessageObserver>();

    public static void registerObserver(MessageObserver observer) {
        observers.add(observer);
    }

    public static void unregisterObserver(MessageObserver observer) {
        observers.remove(observer);
    }

    public static void notifyObservers(String sender, String message) {
        for (MessageObserver observer : observers) {
            //System.out.println("Notifying " + observer + " about " + message);
            observer.messageReceived(sender, message);
        }
    }

}
