package curso.demo17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegEx, Replace
 * @author EM
 */
public class Demo06 {
    public static void main(String[] args) {
        String text = "Hola a todo y toda y todoreos";

        Matcher m = Pattern.compile("(?<id>tod[ao]\\b)").matcher(text);
        text = m.replaceAll("${id}s");

        System.out.println(text);

        text = "<14,2>";
        m = Pattern.compile("<(?<x>\\d+),(?<y>\\d+)>").matcher(text);
        text = m.replaceAll("{x:${x},y:${y}");
        System.out.println(text);
    }

}
