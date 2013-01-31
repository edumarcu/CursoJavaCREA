package curso.ej14_03;

import java.util.Scanner;

public class CommandClient {

    public static void main(String[] args) throws Exception {
        CommandExecutor executor = new CommandExecutor();

        PointServerAPI server = new PointServerAPI(executor);


        boolean exit = false;
        do {

            switch (showOptions()) {
                case 1:
                    server.addPoint(new Point(3,5));
                    break;
                case 2:
                    server.removePoint(new Point(3,5));
                    break;
                case 3:
                    server.containsPoint(new Point(3,5));
                    break;
                case 4:
                    server.listPoints();
                    break;
                case 5:
                    exit = true;
                    break;
            }

//        server.addPoint(new Point(3,5));
//        server.listPoints();
//        server.addPoint(new Point(10,50));
//        server.listPoints();
//        server.addPoint(new Point(10,50));
//        server.listPoints();
//
//        server.removePoint(new Point(3,5));
//        server.listPoints();
//        server.removePoint(new Point(3,5));
//        server.listPoints();
//
//        server.containsPoint(new Point(3,5));
//        server.listPoints();
//        server.containsPoint(new Point(10,50));
//        server.listPoints();

        } while(!exit);
    }


    public static int showOptions() {
        System.out.println("Select Option:");
        System.out.println("1 - Add a Point");
        System.out.println("2 - Remove a Point");
        System.out.println("3 - Point existent?");
        System.out.println("4 - List Points");
        System.out.println("5 - Exit");
        System.out.print("> ");

        return (new Scanner(System.in)).nextInt();
    }
}
