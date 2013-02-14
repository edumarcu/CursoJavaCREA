package curso.ej07_02;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static void main(String[] args) {
        String text = "10-02-2013";
        String regex = "(?<d>\\d{2})-(?<m>\\d{2})-(?<y>\\d{4})";

        Matcher m = Pattern.compile(regex).matcher(text);

        String english = m.replaceAll("${m}-${d}-${y}");
        System.out.println("English: " + english);

        String log = m.replaceAll("${y}${m}${d}");
        System.out.println("Log: " + log);

        english = m.replaceAll("$2-$1-$3");
        System.out.println("English: " + english);

        log = m.replaceAll("$3$2$1");
        System.out.println("Log: " + log);
    }
}
