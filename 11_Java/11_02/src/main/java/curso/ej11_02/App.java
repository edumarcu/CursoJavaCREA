package curso.ej11_02;

import curso.ej11_02.academy.Academy;
import curso.ej11_02.academy.Student;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Using Files, Directories
 * @Author EM
 */
public class App {

    private static Academy academy;

    public static void main( String[] args ) throws FileNotFoundException, IOException {
        System.out.println("Welcome!");
        System.out.println();
        /*
         * Each student in one file and recover them
         */

        try {
            academy = curso.ej11_02.academy.App.loadAcademy();
        } catch (Exception e){
            System.out.println("Exception: " + e);
        }

        // Write
        System.out.println("Saving Students...");

        System.out.print("\tcreating directory...");
        String dirStudents = File.separatorChar + "students"
                + File.separatorChar;
        File outDir = new File(dirStudents);
        if (!outDir.exists()) {
            if (outDir.mkdirs()) {
                System.out.println("OK!");
            }
            else {
                System.out.println("KO");
            }
        }
        System.out.println("\t" + dirStudents);

        String fileStudents = "students.data";
        FileOutputStream fos = new FileOutputStream(dirStudents + fileStudents);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream out = new ObjectOutputStream(bos);

        for (Student student : academy.listStudents()) {
            out.writeObject(student);
            System.out.println("\t" + student);
        }

        System.out.println("OK!");
        out.close();
    }
}
