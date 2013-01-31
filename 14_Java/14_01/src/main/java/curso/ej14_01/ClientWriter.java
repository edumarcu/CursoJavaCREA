package curso.ej14_01;

import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("192.168.11.66", 3450);

        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");

        do {
            System.out.print("> ");
            String message = scanner.nextLine();

            if (message.startsWith("\\q")) {
                break;
            }

            out.write(message + "\n");
            out.flush();
        } while (true);

        socket.close();
    }

}
