package curso.demo19_crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class Demo04_Base64Parser {

    public static void main(String[] args) throws IOException {

        File file = new File("/var/folders/ty/d50nfg8x1vvg04kcvl9yclqm0000gn/T/clasebase64-3618308815743157502.txt");
        FileInputStream fis = new FileInputStream(file);
        // fis sería mi fuente de datos. Un archivo, la red, etc…
        // fis está cifrado
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader in = new BufferedReader(isr);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream out = new BufferedOutputStream(baos);

        char[] buffer = new char[4]; // Uso un mútiplo de 4
        int read = 0;
        while ((read = in.read(buffer)) >= 0) {
            char[] readchars = Arrays.copyOfRange(buffer, 0, read);
            String base64 = new String(readchars);

            byte[] bytes = DatatypeConverter.parseBase64Binary(base64);
            out.write(bytes);
        }

        in.close();
        out.close();

        String parsedString = new String(baos.toByteArray());

        System.out.println("Leído: " + parsedString);
    }
}
