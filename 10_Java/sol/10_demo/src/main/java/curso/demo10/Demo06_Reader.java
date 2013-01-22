package curso.demo10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Demo06_Reader {
    public static void main(String[] args) throws IOException {
        InputStream is = Demo06_Reader.class.getResourceAsStream("file.txt");
        Reader in = new InputStreamReader(is, "UTF-8");
        BufferedReader bin = new BufferedReader(in);

        String line;
        while ((line = bin.readLine()) != null) {
            System.out.println(line);
        }

        bin.close();
    }
}
