package curso.demo17_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo06_Replace {

    public static void main(String[] args) {
        String text = "Hola a todo y toda. Dijimos que todos los foos son sobretodo muy bar…";

//        text = text.replace("todo", "todos");
//        text = text.replace("toda", "todas");

//        text = text.replaceAll("todo", "todos");
//        text = text.replaceAll("toda", "todas");

        Matcher matcher = Pattern.compile("\\btod[oa]\\b").matcher(text);

        text = matcher.replaceAll("$0s");

        System.out.println(text);


        text = "<10,35>";
        matcher = Pattern.compile("<(?<x>\\d+),(?<y>\\d+)>").matcher(text);

        text = matcher.replaceAll("{x:${x},y:${y}}");

        System.out.println(text);
    }
}
