package curso.demo19_crypto;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

public class Demo02_Base64Stream {

    public static void main(String[] args) throws IOException {

        byte[] buf = "Hola a todos".getBytes();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        // bais sería mi fuente de datos. Un archivo, la red, etc…
        // bais está descifrado
        BufferedInputStream in = new BufferedInputStream(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // baos sería dónde almaceno la fuente de datos.
        // baos está descifrado
        BufferedOutputStream out = new BufferedOutputStream(baos);

        byte[] buffer = new byte[3];
        int read = 0;
        StringBuilder sb = new StringBuilder();
        while ((read = in.read(buffer)) >= 0) {
            byte[] readbytes = Arrays.copyOfRange(buffer, 0, read);

            String base64 = DatatypeConverter.printBase64Binary(readbytes);
            // base64 sería mis bytes cifrados.
            // Si estoy cifrando, iré guardándolos en un archivo, o en memoria…
            sb.append(base64);

            // Si estoy descifrando, los interpretaré en múltiplos de 3
            byte[] parsedBytes = DatatypeConverter.parseBase64Binary(base64);
            // y los guardaré en un archivo, memoria, etc…
            out.write(parsedBytes);
        }

        in.close();
        out.close();
        String parsedText = new String(baos.toByteArray());

        System.out.println("BASE64: " + sb.toString());
        System.out.println("Parsed: " + parsedText);
    }
}
