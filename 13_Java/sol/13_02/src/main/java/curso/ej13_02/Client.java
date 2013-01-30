package curso.ej13_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("192.168.11.133", 3450);

        OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
        InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        String message = "Hola Server Ke ASE\n";
        out.write(message);
        out.flush();
        System.out.println("Mensaje Enviado");

        String result = in.readLine();
        System.out.println("Resultado: " + result);

        socket.close();
    }

}
