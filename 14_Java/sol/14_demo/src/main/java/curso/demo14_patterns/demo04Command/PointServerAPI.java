package curso.demo14_patterns.demo04Command;

public class PointServerAPI {

    CommandExecutor executor;

    public PointServerAPI(CommandExecutor executor) {
        this.executor = executor;
    }

    public void addPoint(Point point) throws Exception {
        AddPointCommand command = new AddPointCommand(point);
        command = executor.executeCommand(command);
        if (command.isOk()) {
            System.out.println("Punto añadido.");
        } else {
            System.out.println("Punto no añadido.");
        }
    }

    public void listPoints() throws Exception {
        ListPointsCommand command = new ListPointsCommand();
        command = executor.executeCommand(command);
        for (Point point : command.getPoints()) {
            System.out.println("\t" + point);
        }
    }

}
