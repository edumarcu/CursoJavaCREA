package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Expresiones regulares, multiple grupos
 * @author EM
 */
public class Demo05 {

    public static void main(String[] args) {

        String text = "1_Edu 2_Jesus 3_Maria";
        String regEx = "(?<id>\\d+)_(?<name>\\w+)";

        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.print("matcher valid: ");
            System.out.println("id: " + m.group("id")
                    + " name: " + m.group("name"));

            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("i: " + i + " group: " + m.group(i));
            }
        }
    }

}
