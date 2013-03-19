package curso.ejercicio3.db;

public class PersistenceException extends Exception {

    public PersistenceException() {
    }

    public PersistenceException(String string) {
        super(string);
    }

    public PersistenceException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PersistenceException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

}
