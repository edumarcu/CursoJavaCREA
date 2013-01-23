package curso.demo11;

import java.io.File;
import java.io.IOException;

public class Demo03_Files {

    public static void main(String[] args) throws IOException {

        File out = new File("/tmp/out.txt");

        System.out.println("Exists: " + out.exists());
        System.out.println("Size: " + out.length());
        System.out.println("Parent: " + out.getParent());
        System.out.println("Absolute: " + out.getAbsolutePath());
        System.out.println("Canonical: " + out.getCanonicalPath()); // throws exception
        System.out.println("Path: " + out.getPath());
        System.out.println("URI: " + out.toURI());
        System.out.println("isFile: " + out.isFile());
        System.out.println("isDirectory: " + out.isDirectory());

        System.out.println();
        System.out.println("Archivos en /tmp:");
        File tmp = out.getParentFile();
        System.out.println("isDirectory: " + tmp.isDirectory());
        for (File file : tmp.listFiles()) {
            char type = file.isDirectory() ? 'd' : 'f';
            System.out.println(type + " " + file.getName());
        }

        System.out.println();
        System.out.println("Archivos en /foo:");
        File foo = new File("/foo");
        System.out.println("isDirectory: " + foo.isDirectory());
        try {
            for (File file : foo.listFiles()) {
                char type = file.isDirectory() ? 'd' : 'f';
                System.out.println(type + " " + file.getName());
            }
        } catch (NullPointerException e) {
            System.out.println("/foo no es un directorio.");
        }

        System.out.println();
        System.out.println("Creando /tmp/foo/bar:");
        File bar = new File("/tmp/foo/bar");
        System.out.println("Exists: " + bar.exists());
        System.out.println("isDirectory: " + bar.isDirectory());
        bar.mkdirs();
        bar.deleteOnExit();
        System.out.println("Exists: " + bar.exists());
        System.out.println("isDirectory: " + bar.isDirectory());

        System.out.println();
        System.out.println("Creando Temporal:");
        File temp = File.createTempFile("curso-", ".tmp");
        temp.deleteOnExit();
        System.out.println("Absolute: " + temp.getAbsolutePath());
        System.out.println("Exists: " + temp.exists());
    }

}
