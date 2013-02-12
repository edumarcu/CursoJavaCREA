package curso.ej17_03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones Regulares, Replace
 * @author EM
 */
public class App {
    public static void main( String[] args ) {
        System.out.println("Bienvenido a Replace");

        Scanner s = new Scanner(System.in);
        Pattern p = Pattern.compile("(?<day>\\d{1,2})-(?<month>\\d{1,2})-(?<year>\\d{4})|end");

        boolean exit = false;
        String token;
        while (!exit) {
            try {
                System.out.print("Introduzca fecha (dd-mm-aaaa) [end] > ");
                token = s.next(p);
                Matcher m = p.matcher(token);

                if (token.equals("end")) {
                    System.out.println("Bye!");
                    exit = true;
                } else {
                    System.out.println(token + " coincide!");
                    System.out.print("Equivalente americano: ");
                    System.out.println(m.replaceAll("${month}-${day}-${year}"));
                }

            } catch (Exception e) {
                System.out.println("No coincide, intentelo de nuevo..");
                s.next();
            }
        }
    }
}
