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

/**
 * Networking, Server
 * @author EM
 */
public class Demo01_Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(3450);

        System.out.println("Server running on port 3450!");
        Socket s = server.accept();

        InputStream is = s.getInputStream();
        Reader in = new InputStreamReader(is, "UTF-8");

        OutputStream os = s.getOutputStream();
        Writer out = new OutputStreamWriter(os);

        char[] message = new char[1024];
        int length;
        boolean error = false;

        while (!error && message[0] != 't' ) {
            length = in.read(message);
            error = length <= 0 || length > 140;
            if (error) {

                //out.write("KO¡\n");
                break;
            }
            String  sourceIP = s.getInetAddress().toString();
            System.out.print("Message from: " + sourceIP + " : ");
            for (char c : message) {
                System.out.print(c);
            }

            System.out.print("Sending OK..");
            out.write("OK!\n");
            out.flush();
            System.out.println("OK!");
        }

        if (message[0] == 't') {
            System.out.println("Ereh un torpedo sesuarrr");
        }

        in.close();
        out.close();
        s.close();
        server.close();
        System.out.println("Server finished!");

    }
}
