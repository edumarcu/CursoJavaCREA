package curso.demo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * I/O
 * @author EM
 */
public class Demo01 {

    public static void main(String[] args) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        while (true) {
        //    System.out.println("-> " + System.in.read());
            String line = in.readLine();
            System.out.println("->" + line);
        }

    }

}
