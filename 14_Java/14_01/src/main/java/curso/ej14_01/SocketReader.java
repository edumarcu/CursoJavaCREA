package curso.ej14_01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class SocketReader implements WorkUnit {

    Socket socket;

    public SocketReader(Socket socket) {
        this.socket = socket;
    }

    public void doWork() throws Exception {
        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        while (true) {
            String message = in.readLine();
            boolean error = message == null || message.length() > 140;

            if (!error) {
                String sourceIP = socket.getInetAddress().toString();
                System.out.println("Mensaje de '" + sourceIP + "' :");
                System.out.println("\t" + message);

                notifyObservers(sourceIP, message);
            }
        }
    }

    List<MessageObserver> observers = new LinkedList<MessageObserver>();

    public void registerObserver(MessageObserver observer) {
        observers.add(observer);
    }

    public void unregisterObserver(MessageObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String sender, String message) {
        for (MessageObserver observer : observers) {
            //System.out.println("Notifying " + observer + " about " + message);
            observer.messageReceived(sender, message);
        }
    }
}
