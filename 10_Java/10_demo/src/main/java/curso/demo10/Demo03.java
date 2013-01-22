package curso.demo10;

import java.io.IOException;
import java.io.InputStream;

/**
 * Input Stream
 * @author EM
 */
public class Demo03 {
    public static void main(String[] args) throws IOException{
        InputStream is = Demo03.class.getResourceAsStream("file.txt");

        System.out.println("Available: " + is.available());
        System.out.println("MarkSupported?: " + is.markSupported());

        int data = 0;
        is.mark(1000000);
        while ((data = is.read()) >= 0) {
            System.out.println(data);
        }

        System.out.println();
        System.out.println("Reset!");

        is.reset();
        byte[] buffer = new byte[2]; // para hdd -> 4096
        int readCount = 0;
        while ((readCount = is.read(buffer)) >= 0) {
            for (int i = 0; i < readCount; i++) {
                System.out.print(" " + buffer[i]);

            }
            System.out.println();
        }
              
        System.out.println();
        System.out.println("Reset!");
        System.out.println("Skip!");

        is.reset();
        buffer = new byte[3];
        readCount = 0;
        int skip = 1;
        int length = 2;
        while ((readCount = is.read(buffer, skip, length)) >= 0) {
            for (byte b : buffer) {
                System.out.print(" " + b);
            }
            /*for (int i = 0; i < readCount; i++) {
                System.out.print(" " + buffer[i]);

            }*/
            System.out.println();
        }

        is.close();
    }
}
