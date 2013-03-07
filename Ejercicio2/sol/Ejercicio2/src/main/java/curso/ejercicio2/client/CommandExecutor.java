package curso.ejercicio2.client;

import curso.ejercicio2.commons.Command;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class CommandExecutor {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public CommandExecutor() throws Exception {
        socket = new Socket("127.0.0.1", 3450);
    }

    public <T extends Command> T executeCommand(T command) throws Exception {
        if (out == null) {
            BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
            out = new ObjectOutputStream(bos);
        }
        out.writeObject(command);
        out.flush();

        if (in == null) {
            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
            in = new ObjectInputStream(bis);
        }

        command = (T) in.readObject();
        return command;
    }

}
