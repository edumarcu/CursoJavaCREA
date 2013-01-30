package curso.ej13_03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        String message = null;
        String result;

        while (!"exit".equals(message)) {
            System.out.print(">");
            message = input.nextLine();
            //System.out.println();

            Socket socket = new Socket("192.168.11.66", 3450);

            OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
            InputStreamReader reader = new InputStreamReader(socket.getInputStream(), "UTF-8");
            BufferedReader in = new BufferedReader(reader);

            out.write(message + '\n');
            out.flush();
            System.out.println("\t-> Mensaje Enviado");

            result = in.readLine();
            System.out.println("\t-> Resultado: " + result);

            socket.close();
        }

    }

}
