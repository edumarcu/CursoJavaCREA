package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones regulares, grupos
 * @author EM
 */
public class Demo03 {

    public static void main(String[] args) {

        String text = "1_Edu";
        String regEx = "(\\d+)_(\\w+)";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);

        if (m.matches()) {
            System.out.println("matcher valid: ");

            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("i: " + i + " group: " + m.group(i));
            }
        }
    }

}
