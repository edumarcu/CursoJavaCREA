package curso.ej13_03;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3450);
        System.out.println("Servidor arrancado en el puerto 3450 esperando conexiones.");

        boolean run = true;
        while (run) {
            Socket socket = server.accept();
            SocketProcessor processor = new SocketProcessor(socket);
            Thread t = new Thread(processor);
            t.start();
        }

        server.close();
        System.out.println("Servidor finalizado.");
    }
}

class SocketProcessor implements Runnable {

    Socket socket;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            processSocket();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void processSocket() throws Exception {
        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        String message = in.readLine();
        boolean error = message == null || message.length() > 140;

        if (!error) {
            String sourceIP = socket.getInetAddress().toString();
            System.out.println("Mensaje de '" + sourceIP + "' :");
            System.out.println("\t" + message);
        }

        OutputStream os = socket.getOutputStream();
        Writer out = new OutputStreamWriter(os);
        if (!error) {
            out.write("OK");
        } else {
            out.write("ERROR");
        }
        out.close();
        socket.close();
    }

    public void doWork() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
