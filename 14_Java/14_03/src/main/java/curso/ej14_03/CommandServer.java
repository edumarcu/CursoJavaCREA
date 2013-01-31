package curso.ej14_03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3450);
        PointStorage points = new PointStorage();

        System.out.println("Server ready");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection received.");

            BufferedInputStream bis;
            ObjectInputStream in;
            BufferedOutputStream bos;
            ObjectOutputStream out;

            try {
                bis = new BufferedInputStream(socket.getInputStream());
                in = new ObjectInputStream(bis);
                bos = new BufferedOutputStream(socket.getOutputStream());
                out = new ObjectOutputStream(bos);
            } catch (Exception e) {
                System.out.println("Client disconnected before sending command");
                continue;
            }


            while (true) {
                System.out.println("Reading Command.");
                Command command = null;
                try {
                    command = (Command) in.readObject();
                } catch (Exception e) {
                    System.out.println("Client disconnected");
                    break;
                }
                System.out.println("Executing Command.");
                command.execute(points);

                System.out.println("Sending Command.");
                out.writeObject(command);
                out.flush();
            }
        }
    }
}
