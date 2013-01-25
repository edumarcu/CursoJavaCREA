package curso.ej11_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import curso.ej11_02.academy.Academy;
import curso.ej11_02.academy.Student;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;

/**
 * Files management with Menu
 * @Author EM
 */
public class App {

    public static void main( String[] args ) throws IOException, ParseException {

        System.out.println("Welcome!" );

        // Load Academy
        System.out.print("Loading Academy...");
        Academy academy = new Academy("","");
        curso.ej11_02.academy.App.loadAcademy(academy);

        if (academy != null) {
            System.out.println("OK!");
            System.out.println();
        }
        else {
            System.out.println("KO");
            return;
        }

        // Create directory and Write Students to files
        System.out.println("Creating Directory and Files for Students...");
        createDirectoryAndFiles(academy, "students", "student");

        // Show Menu
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        int opcion = 0;
        while (opcion != 3) {
            printMenu();
            opcion = getOpcion(in);

            switch (opcion) {
                case 1:
                    listStudents(academy);
                    break;
                case 2:
//                    createNewStudent();
                    break;
            }
        }



        System.out.println("Bye!" );
    }

    public static void listStudents(Academy academy) {
        for (Student student : academy.listStudents()) {
            System.out.println("\t" + student);
        }
    }

    public static void createDirectoryAndFiles (Academy academy, String dirName,
            String filePreName) throws FileNotFoundException, IOException {

        System.out.print("\tcreating directory...");
        String dirStudents = File.separatorChar + dirName
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

        String fileStudents = filePreName + ".data";
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

    public static void printMenu() {
        System.out.println();
        System.out.println("Hi, what do you want to do?");
        System.out.println("\t1 - List Students");
        System.out.println("\t2 - Create new Student");
        System.out.println("\t3 - Exit");
    }

    public static int getOpcion (BufferedReader in) throws IOException {
        String line = in.readLine();
        return(Integer.parseInt(line));
    }
}
