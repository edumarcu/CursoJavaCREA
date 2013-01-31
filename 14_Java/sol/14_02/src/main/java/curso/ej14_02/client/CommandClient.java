package curso.ej14_02.client;

import curso.ej14_02.commons.Point;

public class CommandClient {

    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutor();

        PointServerAPI server = new PointServerAPI(executor);

        server.addPoint(new Point(3,5));
        server.addPoint(new Point(10,50));
        server.addPoint(new Point(10,50));
        server.listPoints();
        server.removePoint(new Point(10,50));
        server.removePoint(new Point(10,50));
        server.listPoints();
        server.containsPoint(new Point(3,5));
        server.containsPoint(new Point(10,50));
        server.listPoints();

    }
}
