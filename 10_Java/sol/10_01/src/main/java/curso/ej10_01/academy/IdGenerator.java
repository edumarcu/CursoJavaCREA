package curso.ej10_01.academy;

public class IdGenerator {

    private int last_id = 0;

    public int nextId() {
        return last_id++;
    }

    public int lastId() {
        return last_id;
    }
}
