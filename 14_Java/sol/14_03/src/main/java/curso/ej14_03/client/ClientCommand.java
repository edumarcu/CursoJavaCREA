package curso.ej14_03.client;

import java.util.Scanner;

public interface ClientCommand {

    void executeCommand(Scanner scanner, PointServerAPI server) throws Exception;

}
