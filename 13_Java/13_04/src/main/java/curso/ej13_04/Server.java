package curso.ej13_04;

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

        WorkQueue queue = new WorkQueue();

        boolean run = true;
        while (run) {
            Socket socket = server.accept();
            queue.addWork(new SocketPooler(socket));
        }

        server.close();
        System.out.println("Servidor finalizado.");
    }
}
class SocketPooler implements WorkUnit {

    Socket socket;

    public SocketPooler(Socket socket) {
        this.socket = socket;
    }

    public void doWork() {
        SocketProcessor processor = new SocketProcessor(socket);
        try {
            processor.processSocket();
        } catch (Exception e) {
            System.err.println("Excetion Process Socket: " + e);
        }
        processor.socketProcessorDestructor();
    }
}

class SocketProcessor implements Runnable {

    Socket socket;
    InputStream is;
    Reader reader;
    BufferedReader in;
    OutputStream os;
    Writer out;

    public SocketProcessor(Socket socket) {
        try {
            this.socket = socket;
            this.is = socket.getInputStream();
            this.reader = new InputStreamReader(is, "UTF-8");
            this.in = new BufferedReader(reader);
            this.os = socket.getOutputStream();
            this.out = new OutputStreamWriter(os);
        } catch (Exception e) {
            System.err.println("Exception SocketProcessor Constructor : " + e);
        }

    }

    public void socketProcessorDestructor() {
        try {
            this.socket.close();
            this.is.close();
            this.reader.close();
            this.in.close();
            this.os.close();
            this.out.close();
        } catch (Exception e) {
            System.err.println("Exception SocketProcessor Destructor : " + e);
        }

    }

    public void run() {
        try {
            processSocket();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void processSocket() throws Exception {

        String message = in.readLine();
        boolean error = message == null || message.length() > 140;

        if (!error) {
            String sourceIP = socket.getInetAddress().toString();
            System.out.println("Mensaje de '" + sourceIP + "' :");
            System.out.println("\t" + message);
        }

        if (!error) {
            out.write("OK\n");
        } else {
            out.write("ERROR\n");
        }
        out.flush();
    }
}

