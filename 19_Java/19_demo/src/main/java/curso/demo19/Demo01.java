package curso.demo19;

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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import javax.xml.bind.DatatypeConverter;

/**
 * Cryptography Base 64, Strings, Streams
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Cryptography! (Base 64)");

        // Strings
        System.out.println("Strings");
        String message = "Hola Jesús ere un t@rpedo";

        String crypted = crypt(message);
        System.out.println("Crypt \"" + message + "\": " + crypted);

        String decrypted = decrypt(crypted);
        System.out.println("Decrypt \"" + crypted + "\": " +  decrypted);

        System.out.println();

        // Streams
        System.out.println("Streams");
        byte messageStream[] = "Hola caracola".getBytes();

        ByteArrayInputStream bais = new ByteArrayInputStream(messageStream);
//        BufferedInputStream bis = new BufferedInputStream(bais);
//
//        OutputStream os = new FileOutputStream(File.createTempFile("crypted", ".txt"));
//        OutputStreamWriter osw = new OutputStreamWriter(os);
//        BufferedWriter bw = new BufferedWriter(osw);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        BufferedOutputStream bos = new BufferedOutputStream(baos);
//
//        InputStream is = new FileInputStream("crypted.txt");
//        InputStreamReader isr = new InputStreamReader(is);
//        BufferedReader br = new BufferedReader(isr);

//        byte buffer[] = new byte[3]; // multiplo de bytes para que salgan caracteres enteros
//        int read;
//        StringBuilder sb = new StringBuilder();
//        while ((read = in.read(buffer)) >= 0 ) {
//            byte[] readBytes = Arrays.copyOfRange(buffer, 0, read);
//            System.out.println("readed :" + new String(readBytes));
//
//
//            String base64 = crypt(new String(readBytes));
//            sb.append(base64);
//            System.out.println("crypted: " + base64);
//
//            byte[] parsedBytes = decrypt(base64).getBytes();
//            out.write(parsedBytes);
//            System.out.println("decrypted :" + new String(parsedBytes));
//
//            System.out.println();
//        }
        System.out.println("Crypting...");
        crypt(bais, "crypt.txt", 3);

        System.out.println("Decrypting..");
        decrypt("crypt.txt", baos, 3);
    }

    public static void crypt (ByteArrayInputStream bais, String fileName,
            int bufferSize) throws IOException {

        BufferedInputStream in = new BufferedInputStream(bais);

        File f = new File(fileName);
        f.createNewFile();

        OutputStream os = new FileOutputStream(f);
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        byte buffer[] = new byte[bufferSize]; // multiplo de bytes para que salgan caracteres enteros
        int read;
        while ((read = in.read(buffer)) >= 0 ) {
            byte[] readBytes = Arrays.copyOfRange(buffer, 0, read);
            System.out.println("readed :" + new String(readBytes));

            String base64 = crypt(new String(readBytes));
            System.out.println("crypted: " + base64);

            bw.write(base64);
            System.out.println();
        }
    }

    public static void decrypt (String fileName, ByteArrayOutputStream baos,
            int bufferSize) throws IOException {

        BufferedOutputStream bos = new BufferedOutputStream(baos);

        InputStream is = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        char[] buffer = new char[bufferSize];
        int read;

        while ((read = br.read(buffer)) >= 0 ) {
            char[] readString = Arrays.copyOfRange(buffer, 0, read);
            System.out.println("readed :" + new String(readString));

            String decrypted = decrypt(new String(readString));
            System.out.println("decrypted: " + decrypted);

            bos.write(decrypted.getBytes());
            System.out.println();
        }
    }

    public static String crypt(String message) {
        return DatatypeConverter.printBase64Binary(message.getBytes());
    }

    public static String decrypt(String crypted) {
        return new String(DatatypeConverter.parseBase64Binary(crypted));
    }
}
