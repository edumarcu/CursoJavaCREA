package curso.ejercicio2.server;

import curso.ejercicio2.commons.Command;
import curso.ejercicio2.commons.MyLibrary;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommandServer {

    public static MyLibrary library = new MyLibrary();

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3450);

        System.out.println("Server ready");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New connection received on "
                    + socket.getInetAddress().getHostAddress() + ":" +
                    + socket.getLocalPort());
            
            System.out.println("from  "
                    + socket.getInetAddress());

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            ObjectInputStream in = new ObjectInputStream(bis);

            String message = (String) in.readObject();
            //System.out.println("Conexion stablished: " + message);
            
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            ObjectOutputStream out = new ObjectOutputStream(bos);
            
            out.writeObject("");
            out.flush();

            while (true) {  
                System.out.println();
                System.out.println("Waiting Command.");
                Command command = (Command) in.readObject();

                System.out.println("Executing Command: " + command);
                command.execute(library);

                System.out.println("Sending Command response." + command);
                out.writeObject(command);
                out.flush();
            }
        }
    }
}
