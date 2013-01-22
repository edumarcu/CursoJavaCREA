package curso.demo10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo08_Serialization {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fos = new FileOutputStream("/tmp/objects.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(new NamedPoint(3,5));

        out.close();

        FileInputStream fis = new FileInputStream("/tmp/objects.txt");
        ObjectInputStream in = new ObjectInputStream(fis);

        NamedPoint p = (NamedPoint) in.readObject();
        System.out.println(p);

        in.close();
    }
}

class Point implements Serializable {

    private final static long serialVersionUID = 1L;

    private int x,y;

    public Point(int x, int y) {
        System.out.println("Constructor…");
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }
}

class NamedPoint extends Point {

    private final static long serialVersionUID = 1L;

    private String nombre = "punto";
//    private String foo = "foo";

    public NamedPoint(int x, int y) {
        super(x,y);
    }

    @Override
    public String toString() {
        return nombre + super.toString();
    }

    private void writeObject(ObjectOutputStream os) throws IOException{
        os.defaultWriteObject();
        os.writeUTF(nombre);
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException{
        System.out.println("Deserializando: " + this);
        is.defaultReadObject();
        System.out.println("Deserializando: " + this);
        nombre = is.readUTF();
    }

}
