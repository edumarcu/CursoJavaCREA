package curso.ej33reflection;

public class Task {

    public static int counter;

    private String name;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    //
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //
    @Override
    public String toString() {
        return "Task{" + "name=" + name + '}';
    }
}
