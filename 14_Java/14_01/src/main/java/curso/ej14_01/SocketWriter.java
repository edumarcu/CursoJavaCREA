package curso.ej14_01;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketWriter implements WorkUnit, MessageObserver {

    Socket socket;
    SocketReader reader;
    BufferedWriter out;

    public SocketWriter(Socket socket, SocketReader reader) {
        this.socket = socket;
        this.reader = reader;
    }

    public void doWork() throws Exception {
        OutputStream os = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(os);
        out = new BufferedWriter(writer);

        reader.registerObserver(this);
    }

    public void messageReceived(String sender, String message) {
        try {
            out.write(sender + "\n");
            out.write(message + "\n");
            out.flush();
            //System.out.println(sender + message);

        } catch (Exception e) {
            reader.unregisterObserver(this);
        }
    }
}
