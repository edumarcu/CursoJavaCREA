package curso.ej13_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("> ");
            String message = scanner.nextLine();

            if (message.startsWith("\\q")) {
                break;
            }

            Socket socket = new Socket("192.168.11.133", 3450);

            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
            BufferedReader in = new BufferedReader(reader);

            out.write(message + "\n");
            out.flush();

            String result = in.readLine();
            System.out.println("Resultado: " + result);
            socket.close();
        } while (true);
    }

}
