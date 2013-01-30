package curso.ej13_05;

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

        WorkerQueue queue = new WorkerQueue();

        ServerSocket server = new ServerSocket(3450);
        System.out.println("Servidor arrancado en el puerto 3450 esperando conexiones.");

        boolean run = true;
        while (run) {
            Socket socket = server.accept();
            SocketProcessor processor = new SocketProcessor(socket);
            queue.addWork(processor);
        }

        server.close();
        System.out.println("Servidor finalizado.");
    }
}

class SocketProcessor implements WorkUnit {

    Socket socket;

    public SocketProcessor(Socket socket) {
        this.socket = socket;
    }

    public void doWork() throws Exception {
        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        OutputStream os = socket.getOutputStream();
        Writer out = new OutputStreamWriter(os);

        boolean run = true;
        while (run) {
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

        out.close();
        socket.close();
    }


}
