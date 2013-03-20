package curso.ej33;

public class Main {

    public static void main(String[] args) throws Exception {
        ActionManager manager = new ActionManager();
        manager.scanClass("curso.ej33.Saludator3000");

        manager.executeAction("hello");
        manager.executeAction("bye");
        manager.executeAction("foo");
    }
}
