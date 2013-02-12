package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones regulares, match location
 * @author EM
 */
public class Demo02 {

    public static void main(String[] args) {

        String text = "hola a todos catodas";
        String regEx = "tod[a|o]s";

        Pattern p = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);

        if (m.find()) {
            System.out.println("matcher start - end: " + m.start() + " - "
                    + m.end() + " -> " + text.substring(m.start(), m.end()));


        }
        if (m.find()) {
            System.out.println("matcher start - end: " + m.start() + " - "
                    + m.end() + " -> " + text.substring(m.start(), m.end()));
        }

    }

}
