package curso.demo17_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo02_MatchLocation {

    public static void main(String[] args) {

        String text = "Hola a todos y todas";
        String regex = "tod[ao]s";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            int start = matcher.start();
            int end = matcher.end();
            System.out.printf("Encontrado desde %d hasta %d", start, end);
            System.out.println();

            String match = text.substring(start, end);
            System.out.println("Match: " + match);
        }

    }

}
