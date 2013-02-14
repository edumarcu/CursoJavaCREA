package curso.demo17_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo04_NamedGroups {

    public static void main(String[] args) {

        String text = "1_Pepe";
        String regex = "(?<id>\\d+)_(?<name>.*)";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()) {
            System.out.println("Es un texto válido");

            Integer id = Integer.parseInt(matcher.group("id"));
            String name = matcher.group("name");

            System.out.println("Hola " + name + "! tu id es: " + id);

        }
    }

}
