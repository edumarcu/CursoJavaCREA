package curso.ej10_01;

import curso.ej09_01.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Serialize Object Student of Academy
 * @Author EM
 */
public class App {
    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        StudentSerializable students[] = {
            new StudentSerializable(),
            new StudentSerializable()
        };
        students[0].setId(StudentSerializable.nextId());
        students[0].setName("Jesus");
        students[0].setAddress("Almacén de reciclaje del parking de GranCasa");
//        academy.addStudent(students[0]);

        students[1].setId(StudentSerializable.nextId());
        students[1].setName("Eduardo");
        students[1].setAddress("Palacio Real");
//        academy.addStudent(students[1]);

        System.out.println("Serialize!");
        for (StudentSerializable studentSerializable : students) {
            System.out.println(studentSerializable);
        }

        FileOutputStream fos = new FileOutputStream("alumnos.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);

        out.writeObject(students[0]);
        out.writeObject(students[1]);
        out.close();

        System.out.println();
        System.out.println("Deserialize!");
        FileInputStream fis = new FileInputStream("alumnos.txt");
        ObjectInputStream in = new ObjectInputStream(fis);

        StudentSerializable st = null;
        try {
            st = (StudentSerializable) in.readObject();
        } catch (Exception e) {
            System.out.print("Exception: ");
            System.out.println(e);
        }
        System.out.println(st);
        st = (StudentSerializable) in.readObject();
        System.out.println(st);

        in.close();
    }
}

    /*
     *
     * TODA LA JERARQUIA TIENE QUE SER SERIALIZABLE
     *
     */
    class PeopleSerializable implements Serializable {
        private int id;

        private String name;

        private String address;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }

    class StudentSerializable extends PeopleSerializable {

        private static int id = 0;

        public static int nextId() {
            return id++;
        }

        @Override
        public String toString() {
            return "Alumno #" + getId() + " nombre:" + getName() +
                    " @:" + getAddress();
    }

/*    class AcademySerializable extends Academy implements Serializable {

        public AcademySerializable(String name, String address) {
            super(name, address);
        }
    }
*/
}
