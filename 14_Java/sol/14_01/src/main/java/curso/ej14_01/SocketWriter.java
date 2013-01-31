package curso.ej14_01;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketWriter implements WorkUnit, MessageObserver {

    Socket socket;
    BufferedWriter out;

    public SocketWriter(Socket socket) {
        this.socket = socket;
    }

    public void doWork() throws Exception {
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        out = new BufferedWriter(writer);

        MessageProxy.instance.registerObserver(this);
    }

    public void messageReceived(String sender, String message) {
        try {
            out.write(sender + "\n");
            out.write(message + "\n");
            out.flush();
        } catch (Exception e) {
            MessageProxy.instance.removeObserver(this);
            System.out.println("Error: " + e.getMessage());
        }
    }


}
