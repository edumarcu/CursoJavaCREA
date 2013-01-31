package curso.ej14_02;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketWriter implements WorkUnit, MessageObserver {

    Socket socket;
    BufferedWriter out;
    String queueNumber;

    public SocketWriter(Socket socket) {
        this.socket = socket;
    }

    public void doWork(String queueNumber) throws Exception {
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        out = new BufferedWriter(writer);

        MessageProxy.registerObserver(this);
        this.queueNumber = queueNumber;
//        System.out.println("SocketWriter:" + queueNumber);
    }

    public void messageReceived(String sender, String message) {
        try {
            out.write(sender + "\n");
            out.write(message + "\n");
            out.flush();
            //System.out.println(sender + message);
            System.out.println("SocketWriter:" + queueNumber);

        } catch (Exception e) {
            MessageProxy.unregisterObserver(this);
            System.err.println("Error: " + e.getMessage());
        }
    }
}
