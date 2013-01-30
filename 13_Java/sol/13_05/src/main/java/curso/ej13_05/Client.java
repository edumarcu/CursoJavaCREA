package curso.ej13_05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        Socket socket = new Socket("192.168.11.133", 3450);

        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        do {
            System.out.print("> ");
            String message = scanner.nextLine();

            if (message.startsWith("\\q")) {
                break;
            }

            out.write(message + "\n");
            out.flush();

            String result = in.readLine();
            System.out.println("Resultado: " + result);
        } while (true);

        socket.close();
    }

}
