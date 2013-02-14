package curso.ej19_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Base64StreamEncoder {

    public static void main(String[] args) throws IOException {
        encodeResource("readme.txt");
        encodeResource("misteryfile");
    }

    public static void encodeResource(String resourcename) throws IOException {
        InputStream is = Base64StreamEncoder.class.getResourceAsStream(resourcename);
        BufferedInputStream in = new BufferedInputStream(is);
        // FIXME: Base64InputStream would be handy here!

        File file = File.createTempFile(resourcename, ".b64.txt");
        System.out.println("Archivo: " + file.getAbsolutePath());
        OutputStream os = new FileOutputStream(file);
        BufferedOutputStream out = new BufferedOutputStream(os);

        byte[] buffer = new byte[3 * 1024]; // Uso un mútiplo de 3
        int read;
        while ((read = in.read(buffer)) >= 0) { // FIXME: Oh, wait a minute! We are not encoding here!
            out.write(buffer, 0, read);
        }

        in.close();
        out.close();

        System.out.println("Archivo Escrito");
    }

}
