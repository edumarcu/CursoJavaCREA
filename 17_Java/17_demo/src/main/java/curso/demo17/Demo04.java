package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones regulares, named groups
 * @author EM
 */
public class Demo04 {

    public static void main(String[] args) {

        String text = "1_Edu";
        String regEx = "(?<id>\\d+)_(?<name>\\w+)";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);

        if (m.matches()) {
            System.out.println("matcher valid: ");
            System.out.println("id: " + m.group("id")
                    + " name: " + m.group("name"));
        }
    }
}
