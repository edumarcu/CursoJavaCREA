package curso.ej19_01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

public class Base64StreamDecoder {


    public static void main(String[] args) throws IOException {
        decodeResource("readme.b64.txt");
        decodeResource("misteryfile.b64.txt");
    }

    public static void decodeResource(String resourcename) throws IOException {
        InputStream is = Base64StreamDecoder.class.getResourceAsStream(resourcename);
        BufferedInputStream in = new BufferedInputStream(is);

        File file = File.createTempFile(resourcename, ".txt");
        System.out.println("Archivo: " + file.getAbsolutePath());
        OutputStream os = new FileOutputStream(file);
        BufferedOutputStream out = new BufferedOutputStream(os);
        Base64OutputStream out64 = new Base64OutputStream(out, false);


        byte[] buffer = new byte[4 * 1024];
        int read;
        while ((read = in.read(buffer)) >= 0) {
            out64.write(buffer, 0, read);
        }

        in.close();
        out64.close();

        System.out.println("Archivo Escrito");

        file.renameTo(new File("C:\\Users\\Usuario\\Ejercicios Java\\19_Java\\19_01\\"
                + "src\\main\\resources\\curso\\ej19_01\\" + resourcename + ".dec"));
        file.delete();
    }
}
