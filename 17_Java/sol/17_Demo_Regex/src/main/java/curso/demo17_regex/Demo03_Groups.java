package curso.demo17_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo03_Groups {

    public static void main(String[] args) {

        String text = "1_Pepe";
        String regex = "(\\d+)_(.*)";

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        if (matcher.matches()) {
            System.out.println("Es un texto válido");

            for (int i = 0; i <= matcher.groupCount(); i++) {
                String group = matcher.group(i);
                System.out.printf("%d %s", i, group);
                System.out.println();
            }

            Integer id = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);

            System.out.println("Hola " + name + "! tu id es: " + id);

        }
    }

}
