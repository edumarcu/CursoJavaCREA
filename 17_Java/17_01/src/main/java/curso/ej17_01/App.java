package curso.ej17_01;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Expresiones Regulares
 * @author EM
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("Bienvenido al comprobador de Expresioens Regulares");

        String opcion = "";
        while (!opcion.equals("salir")) {

            opcion = showMenu();
            switch (opcion) {
                case "1":
                    testStringRegEx("00000000-A", "\\d{7}-[A-Z]");
                    break;

                case "2":
                    testStringRegEx("2010-12-24 12:00:00",
                            "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
                    break;

                case "3":
                    testStringRegEx("abcd", "\\w{4}");
                    break;
            }
        }
    }

    public static String showMenu() {
        Scanner s = new Scanner(System.in);
        String input;
        do {
            System.out.println();
            System.out.println("Seleccione una de las siguientes opciones...");
            System.out.println("-------------------------------------------");
            System.out.println("1 - DNI (00000000-A)");
            System.out.println("2 - Fecha (2010-12-24 12:00:00)");
            System.out.println("3 - Palabra 4 letras (abcd)");
            System.out.print("> ");
            input = s.next();
        } while (!input.matches("(1|2|3|salir)"));
        return input;
    }

    public static void testStringRegEx(String example, String RegEx) {
        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile(RegEx);

        while (true) {
            System.out.print(example + " > ");
            try {
                System.out.println(s.next(p) + " coincide!");
                break;

            } catch (Exception e) {
                System.out.println("No coincide, intentelo de nuevo..");
                s.next();
            }
        }
    }
}
