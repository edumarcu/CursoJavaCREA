package curso.ej17_02.client;

import curso.ej17_02.commons.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandClient {

    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutor();
        PointServerAPI server = new PointServerAPI(executor);

        boolean exit = false;
        while (!exit) {

            switch (showMenu()) {
                case "1":
                    Pattern p = Pattern.compile("<(?<x>\\d+),(?<y>\\d+)>");
                    for (String token :testStringRegEx("add <2,3> | [end]", "<\\d+,\\d+>|end")) {
                        if (!token.equals("end")) {
                            Matcher m = p.matcher(token);
                            m.matches();

                            server.addPoint(new Point(Integer.parseInt(m.group("x")),
                                                      Integer.parseInt(m.group("y"))));
                        }
                    }
                    break;

                case "2":
                    server.listPoints();
                    break;

                case "3":
                case "exit":
                    exit = true;
                    break;
            }
        }
        System.out.println("Bye!");
    }

    public static ArrayList<String> testStringRegEx(String example, String RegEx) {
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile(RegEx);
        ArrayList<String> tokensCoincidents = new ArrayList<>();
        String token;

        boolean exit = false;
        while (!exit) {
            System.out.print(example + " > ");
            try {
                token = s.next(p);
                System.out.println(token + " coincide!");
                tokensCoincidents.add(token);
                if (token.equals("end")) {
                    exit = true;
                }

            } catch (Exception e) {
                System.out.println("No coincide, intentelo de nuevo..");
                s.next();
            }
        }
        return tokensCoincidents;
    }

    public static String showMenu() {
        Scanner s = new Scanner(System.in);
        String input;
        do {
            System.out.println();
            System.out.println("Select an option");
            System.out.println("-------------------------------------------");
            System.out.println("1 - Add a point");
            System.out.println("2 - List points");
            System.out.println("3 - exit");
            System.out.print("> ");
            input = s.next();
        } while (!input.matches("(1|2|3|exit)"));
        return input;
    }
}
