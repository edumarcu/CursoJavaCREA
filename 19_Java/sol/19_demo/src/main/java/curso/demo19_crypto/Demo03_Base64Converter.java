package curso.demo19_crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class Demo03_Base64Converter {

    public static void main(String[] args) throws IOException {

        byte[] buf = "Hola a todos".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        // bais sería mi fuente de datos. Un archivo, la red, etc…
        // bais está descifrado
        BufferedInputStream in = new BufferedInputStream(bais);

        File file = File.createTempFile("clasebase64-", ".txt");
        System.out.println("Archivo: " + file.getAbsolutePath());
        OutputStream os = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter out = new BufferedWriter(osw);

        byte[] buffer = new byte[3]; // Uso un mútiplo de 3
        int read = 0;
        while ((read = in.read(buffer)) >= 0) {
            byte[] readbytes = Arrays.copyOfRange(buffer, 0, read);

            String base64 = DatatypeConverter.printBase64Binary(readbytes);
            // base64 sería mis bytes cifrados.
            // Si estoy cifrando, iré guardándolos en un archivo, o en memoria…
            out.write(base64);
        }

        in.close();
        out.close();

        System.out.println("Archivo Escrito");
    }
}
