package curso.ejercicio2.server;

import curso.ejercicio2.commons.Command;
import curso.ejercicio2.commons.Library;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3450);
        Library library = new LibraryImpl();

        System.out.println("Server ready");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection received.");

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            ObjectInputStream in = new ObjectInputStream(bis);

            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(bos);

            while (true) {
                System.out.println("Reading Command.");
                Command command = (Command) in.readObject();

                System.out.println("Executing Command.");
                command.execute(library);

                System.out.println("Sending Command.");
                out.writeObject(command);
                out.flush();
            }
        }
    }
}
