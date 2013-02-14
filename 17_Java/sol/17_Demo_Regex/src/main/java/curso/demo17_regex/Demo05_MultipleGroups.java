package curso.demo17_regex;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo05_MultipleGroups {

    public static void main(String[] args) {

        String text = "1_Pepe2_Pablo3_Patricia";
        String regex = "(?<id>\\d+)_(?<name>[^\\d]+)";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Es un texto válido");

            String id = matcher.group("id");
            String name = matcher.group("name");
            System.out.println("Hola " + name + "! tu id es: " + id);
        }
    }

}
