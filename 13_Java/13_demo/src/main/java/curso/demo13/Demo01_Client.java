package curso.demo13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

/**
 * Networking, Client
 * @author EM
 */
public class Demo01_Client {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("192.168.11.66", 3450);

        OutputStream os = s.getOutputStream();
        Writer out = new OutputStreamWriter(os);
        InputStream is = s.getInputStream();
        Reader reader = new InputStreamReader(is, "UTF-8");
        BufferedReader in = new BufferedReader(reader);

        String message = "Hola\n";
        out.write(message);
        out.flush();
        System.out.println("Message sent!");

        String result = in.readLine();
        System.out.println("Result: " + result);

        in.close();
        out.close();
        s.close();

    }

}
