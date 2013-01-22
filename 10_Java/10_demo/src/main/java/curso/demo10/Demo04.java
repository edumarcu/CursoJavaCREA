package curso.demo10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Output Stream
 * @author EM
 */
public class Demo04 {

    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("out.txt");
        byte[] data = {65, 66, 67, 68, 69, 70};

        os.write(data);
        os.close();

        os = new FileOutputStream("out2.txt");
        InputStream is = Demo03.class.getResourceAsStream("file.txt");

        byte[] buffer = new byte[3];
        int readCount;

        while ((readCount = is.read(buffer)) >= 0) {
            os.write(buffer, 0 , readCount);
            // si no readCount, escribe todo el buffer.. mas de lo necesario
        }

        os.close();
        is.close();
    }

}
