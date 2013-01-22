package curso.demo10;

import java.io.IOException;
import java.io.InputStream;

public class Demo03_InputStream {
    public static void main(String[] args) throws IOException {
        InputStream is = Demo03_InputStream.class.getResourceAsStream("file.txt");
        System.out.println("Available: " + is.available());
        System.out.println("isMarkSupported: " + is.markSupported());
        is.mark(100000000);
        int data = 0;
        while((data = is.read()) >= 0) {
            System.out.println(data);
        }

        System.out.println();
        System.out.println("Reset!");
        is.reset();
        byte[] buffer = new byte[2]; // para hdd -> 4096
        int readCount = 0;
        while((readCount = is.read(buffer)) >= 0) {
            for (int i = 0; i < readCount; i++) {
                System.out.print(" " + buffer[i]);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Reset!");
        is.reset();
        buffer = new byte[3]; // para hdd -> 4096
        readCount = 0;
        while((readCount = is.read(buffer, 1, 2)) >= 0) {
            for (byte b : buffer) {
                System.out.print(" " + b);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Reset!");
        is.reset();
        System.out.println("Skip!");
        is.skip(2);
        buffer = new byte[2]; // para hdd -> 4096
        while((readCount = is.read(buffer)) >= 0) {
            for (byte b : buffer) {
                System.out.print(" " + b);
            }
            System.out.println();
        }

        is.close();
    }
}
