package curso.demo14_patterns.demo04Command;

public class CommandClient {

    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutor();

        PointServerAPI server = new PointServerAPI(executor);

        server.addPoint(new Point(3,5));
        server.addPoint(new Point(10,50));
        server.addPoint(new Point(10,50));
        server.listPoints();
        
    }
}
