package curso.ej14_01;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static SocketReader reader = null;

    public final static WorkerQueue queue = new WorkerQueue();

    public static void main(String[] args) throws Exception {


        ServerSocket server = new ServerSocket(3450);
        System.out.println("Servidor arrancado en el puerto 3450 esperando conexiones.");

        try {
            while (true) {
                Socket socket = server.accept();
                WorkUnit unit;

                if (reader == null) {
                    reader = new SocketReader(socket);
                    unit = reader;
                } else {
                    unit = new SocketWriter(socket);
                }

                queue.addWork(unit);
            }
        } finally {
            server.close();
            System.out.println("Servidor finalizado.");
        }
    }
}
