package curso.ej14_01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("192.168.11.133", 3450);

        InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        String sender;
        do {
            sender = in.readLine();
            System.out.println("Mensaje de : " + sender);

            String message = in.readLine();
            System.out.println(message);
        } while (sender != null);
    }

}
