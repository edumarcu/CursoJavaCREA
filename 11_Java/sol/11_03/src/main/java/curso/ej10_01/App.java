package curso.ej10_01;

import curso.ej10_01.academy.Student;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

public class App {

    static File outdir;
    static Scanner in;

    public static void main(String[] args) throws Exception {

        String outdirPath = "/tmp/students";
        outdir = new File(outdirPath);
        outdir.deleteOnExit();
        if (!outdir.exists()) {
            outdir.mkdirs();
        }

        in = new Scanner(System.in);

        loadAcademy();

        menu:
        while (true) {
            System.out.println();
            System.out.println("¿Qué desea hacer?");
            System.out.println("  1 - Listar Alumnos.");
            System.out.println("  2 - Registrar Alumnos.");
            System.out.println("  3 - Salir.");
            System.out.println();
            System.out.print("[1,2,3] >");

            int option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    listStudents();
                    break;
                case 2:
                    saveStudent();
                    break;
                case 3:
                    // Salir
                    System.out.println("");
                    break menu;
            }
        }
    }

    public static void listStudents() throws FileNotFoundException, IOException, ClassNotFoundException {
        Collection<Student> students = new LinkedList<Student>();
        File[] files = outdir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                //return name.matches(".*\\.data$");
                return name.endsWith(".data");
            }
        });
        for (File file : files) {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream in = new ObjectInputStream(bis);

            Student student = (Student) in.readObject();
            students.add(student);

            in.close();
        }

        System.out.println("Alumnos leídos:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void saveStudent() throws Exception {
        Student student = new Student();

        System.out.println("Introduzca el nombre del alumno: ");
        System.out.print("> ");
        String name = in.nextLine();
        student.setName(name);

        System.out.println("Introduzca la dirección del alumno: ");
        System.out.print("> ");
        String address = in.nextLine();
        student.setAddress(address);

        student.setId(Student.nextId());

        saveStudent(student);
    }

    public static void saveStudent(Student student) throws FileNotFoundException, IOException, IOException {
        String outfilePath = student.getId() + "-" + student.getName() + ".data";
        File outFile = new File(outdir, outfilePath);

        FileOutputStream fos = new FileOutputStream(outFile);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream out = new ObjectOutputStream(bos);

        out.writeObject(student);
        System.out.println("Guardado:" + student);

        out.close();
    }

    /*
     // Write
     System.out.println("Guardando Alumnos:");
     for (Student student : academy.listStudents()) {

     }

     System.out.println("Alumnos guardados:");

     */
    public static void loadAcademy() throws Exception {

         Student st1 = new Student();
         st1.setId(Student.nextId());
         st1.setName("Pedro");
         st1.setAddress("Calle no existente 5");
         saveStudent(st1);

         Student st2 = new Student();
         st2.setId(Student.nextId());
         st2.setName("Pablo");
         st2.setAddress("Calle no existente 10");
         saveStudent(st2);

         Student st3 = new Student();
         st3.setId(Student.nextId());
         st3.setName("Paula");
         st3.setAddress("Calle no existente 10");
         saveStudent(st3);

    }
}
