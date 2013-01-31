package curso.ej14_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("192.168.11.66", 3450);

        InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        do {
            String sender = in.readLine();
            System.out.println("Mensaje de : " + sender);

            String message = in.readLine();
            System.out.println("\t" + message);
        } while (true);
    }

}
