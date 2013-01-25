package curso.demo13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo01_Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(3450);

        System.out.println("Servidor arrancado en el puerto 3450 esperando conexiones.");
        Socket socket = server.accept();

        InputStream is = socket.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        /*
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for (; length < 142; length++) {
            int b = in.read();
            if (b == -1) {
                break;
            }

            char c = (char) b;
            if ( c == '\n') {
                break;
            }

            sb.append(c);
        }
        String message = sb.toString();
        boolean error = message == null || message.length() > 140;
        */
        String message = in.readLine();
        boolean error = message == null || message.length() > 140;

        if (!error) {
            String sourceIP = socket.getInetAddress().toString();
            System.out.println("Mensaje de '" + sourceIP + "' :");
            System.out.println("\t" + message);
        }

        OutputStream os = socket.getOutputStream();
        Writer out = new OutputStreamWriter(os);
        if (!error) {
            out.write("OK");
        } else {
            out.write("ERROR");
        }
        out.close();
        socket.close();


        server.close();
        System.out.println("Servidor finalizado.");
    }

}
