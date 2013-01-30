package curso.demo14_patterns;

import java.util.Properties;

// Singleton: Final class
public final class Demo02_Singleton {

    // Singleton: instance
    // private static and final
    private static final Demo02_Singleton instance = new Demo02_Singleton();

    // Singleton: instance accessor
    public static Demo02_Singleton getInstance() {
        return instance;
    }


    //

    Properties conf = new Properties();

    // Singleton: Private Constructor
    private Demo02_Singleton() {
        conf.setProperty("color", "red");
    }

    public synchronized Object setProperty(String key, String value) {
        return conf.setProperty(key, value);
    }

    public String getProperty(String key) {
        return conf.getProperty(key);
    }

    //

    public static void main(String[] args) {
        System.out.println("Arrancando App:");
        System.out.println("Color de fondo: " + Demo02_Singleton.getInstance().getProperty("color"));
    }

}
