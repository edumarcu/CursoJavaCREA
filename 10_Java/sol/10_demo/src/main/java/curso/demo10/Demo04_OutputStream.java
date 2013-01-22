package curso.demo10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Demo04_OutputStream {
    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("/tmp/out.txt");

        byte[] data = { 65, 66, 67, 68, 69 };
        os.write(data);

        os.close();

        os = new FileOutputStream("/tmp/out2.txt");
        InputStream is = Demo03_InputStream.class.getResourceAsStream("file.txt");

        
        int readCount = 0;
        byte[] buffer = new byte[3];
        while ((readCount = is.read(buffer)) >= 0) {
            os.write(buffer, 0, readCount);
        }

        is.close();
        os.close();
    }
}
