package curso.ej14_03.client;

import curso.ej14_03.commons.Point;
import java.util.Scanner;

public class AddPointClientCommand implements ClientCommand{

    public void executeCommand(Scanner scanner, PointServerAPI server) throws Exception{
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        server.addPoint(new Point(x,y));
    }

}
