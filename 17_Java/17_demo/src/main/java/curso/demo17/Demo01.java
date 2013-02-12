package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones Regulares
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) {

        matches("a", "a"); //^a$
        matches("hola", "a");

        Pattern preRegEx1 = Pattern.compile("a");
        Matcher matcher1 = preRegEx1.matcher("hola");

        if (matcher1.matches()) {
            System.out.println("hola coincide con a");
        } else {
            System.out.println("hola no coincide con a");
        }

        if (matcher1.find()) {
            System.out.println("hola contiene a");
        } else {
            System.out.println("hola no contiene a");
        }

        find("hola", "a");
        find("caracola", "a");
        find("pepe", "a");

        find("hola", "^a");
        find("acabo", "^a");
        find("acabo", "a$");
        find("boca", "a$");
        find("a", "^a$");
        find("acaba", "^a(.)*a$");

    }
    public static void find(String string, String regex) {
        System.out.print(string);
        Pattern compiledRegEx = Pattern.compile(regex);
        Matcher matcher = compiledRegEx.matcher(string);
        if (!matcher.find()) {
            System.out.print(" no");
        }
        System.out.println(" contiene " + regex);
    }


    public static void matches(String string, String regex) {
        System.out.print(string);
        if (!string.matches(regex)) {
            System.out.print(" no");
        }
        System.out.println(" coincide con " + regex);
    }
}
