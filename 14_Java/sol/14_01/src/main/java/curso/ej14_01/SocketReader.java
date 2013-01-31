package curso.ej14_01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.Socket;

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

                MessageProxy.instance.notifyObservers(sourceIP, message);
            }
        }
    }


}
