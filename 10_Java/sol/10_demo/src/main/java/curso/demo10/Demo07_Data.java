package curso.demo10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo07_Data {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/tmp/data.txt");
        DataOutputStream out = new DataOutputStream(fos);

        out.writeInt(35);
        out.writeBoolean(false);
        out.writeUTF("Hola");

        out.close();

        FileInputStream fis = new FileInputStream("/tmp/data.txt");
        DataInputStream in = new DataInputStream(fis);

        System.out.println(in.readBoolean());
        System.out.println(in.readInt());
        System.out.println(in.readUTF());
    }
}
