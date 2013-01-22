package curso.demo10;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Demo05_Buffered {
    public static void main(String[] args) throws IOException {
        InputStream is = Demo05_Buffered.class.getResourceAsStream("file.txt");
        BufferedInputStream bis = new BufferedInputStream(is);

        System.out.println("Available " + bis.available());

        byte[] buffer = new byte[1024];
        int readCount = 0;
        while((readCount = bis.read(buffer)) >= 0) {
            for (int i = 0; i < readCount; i++) {
                System.out.println(buffer[i]);
            }
        }
        is.close();
    }
}
