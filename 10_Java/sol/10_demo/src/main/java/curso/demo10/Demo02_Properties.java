package curso.demo10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Demo02_Properties {

    public static void main(String[] args) throws IOException {
        Properties system = System.getProperties();
        System.out.println("miPropiedad: " + system.getProperty("miPropiedad"));
        System.out.println("otraProp: " + system.getProperty("otraProp", "OtroValorPorDefecto"));
        System.out.println("otraProp: " + system.getProperty("otraProp"));
        system.setProperty("otraProp", "miValor");
        System.out.println("otraProp: " + system.getProperty("otraProp"));

        Properties properties = new Properties();
        properties.load(Demo02_Properties.class.getResourceAsStream("/curso/demo10/miapp.properties"));
        System.out.println("Nombre: " + properties.getProperty("name"));
        properties.setProperty("name", "Capitán GoLo");
        properties.store(new FileOutputStream(new File("/tmp/foo.properties")), "Propiedades modificadas");
        properties.storeToXML(new FileOutputStream(new File("/tmp/foo.xml")), "Propiedades modificadas");
    }
}
