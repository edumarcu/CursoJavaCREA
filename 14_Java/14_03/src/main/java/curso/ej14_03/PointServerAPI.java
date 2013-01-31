package curso.ej14_03;

public class PointServerAPI {

    CommandExecutor executor;

    public PointServerAPI(CommandExecutor executor) {
        this.executor = executor;
    }

    public void addPoint(Point point) throws Exception {
        AddPointCommand command = new AddPointCommand(point);
        command = executor.executeCommand(command);
        if (command.isOk()) {
            System.out.println("Point " + point + " added.");
        } else {
            System.out.println("Point " + point
                    + " not added, (already existent?).");
        }
        System.out.println();
    }

    public void removePoint(Point point) throws Exception {
        RemovePointCommand command = new RemovePointCommand(point);
        command = executor.executeCommand(command);
        if (command.isOk()) {
            System.out.println("Point " + point + " removed.");
        } else {
            System.out.println("Point " + point + " not removed, (not existent?).");
        }
        System.out.println();
    }

    public void containsPoint(Point point) throws Exception {
        ContainsPointCommand command = new ContainsPointCommand(point);
        command = executor.executeCommand(command);
        if (command.isOk()) {
            System.out.println("Point " + point + " existent.");
        } else {
            System.out.println("Point " + point + " not existent.");
        }
        System.out.println();
    }

    public void listPoints() throws Exception {
        ListPointsCommand command = new ListPointsCommand();
        command = executor.executeCommand(command);
        System.out.println("Listing Points:");
        for (Point point : command.getPoints()) {
            System.out.println("\t" + point);
        }
        System.out.println();
    }

}
