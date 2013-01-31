package curso.ej14_03.client;

import java.util.HashMap;
import java.util.Scanner;

public class CommandClient {

    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutor();
        PointServerAPI server = new PointServerAPI(executor);

        HashMap<String, ClientCommand> commands = new HashMap<String, ClientCommand>();
        commands.put("add", new AddPointClientCommand());

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("> ");
            String command = scanner.next();

            ClientCommand clientcommand = commands.get(command);

            if (clientcommand != null) {
                clientcommand.executeCommand(scanner, server);
            } else {
                System.out.println("Command not found.");
            }
            scanner.nextLine();

            server.listPoints();
        }

    }
}
