package curso.ej14_02.client;

import curso.ej14_02.commons.Point;
import curso.ej14_02.commons.RemovePointCommand;
import curso.ej14_02.commons.ContainsPointCommand;
import curso.ej14_02.commons.AddPointCommand;
import curso.ej14_02.commons.ListPointsCommand;

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

    public void removePoint(Point point) throws Exception {
        RemovePointCommand command = new RemovePointCommand(point);
        command = executor.executeCommand(command);
        if (command.isOk()) {
            System.out.println("Punto borrado.");
        } else {
            System.out.println("Punto no borrado.");
        }
    }

    public void containsPoint(Point point) throws Exception {
        ContainsPointCommand command = new ContainsPointCommand(point);
        command = executor.executeCommand(command);

        if (command.isContains()) {
            System.out.println("El servidor contiene el punto " + point);
        } else {
            System.out.println("El servidor no contiene el punto " + point);
        }
    }
}
