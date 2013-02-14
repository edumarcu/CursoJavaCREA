package curso.ej14_02.client;

import curso.ej14_02.commons.Point;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPointClientCommand implements ClientCommand{

    public void executeCommand(Scanner scanner, PointServerAPI server) throws Exception{
        String point = scanner.next();
        String pointRegex = "<(?<x>\\d+),(?<y>\\d+)>";
        String argRegex = "(" + pointRegex + ")+";

        Matcher argMatcher = Pattern.compile(argRegex).matcher(point);

        if (!argMatcher.matches()) {
            System.out.println("No es un argumento válido. <x,y>+");
            return;
        }

        Matcher m = Pattern.compile(pointRegex).matcher(point);

        while(m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));

            server.addPoint(new Point(x,y));
        }
    }


    public static void main(String[] args) {
        String point = "<3,5><11,23>#4,5#";
        String regex = "<(?<x>\\d+),(?<y>\\d+)>";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(point);

        while (matcher.find()) {
            System.out.println("Correcto:");
            System.out.println("x: " + matcher.group("x"));
            System.out.println("y: " + matcher.group("y"));
        }
    }
}
