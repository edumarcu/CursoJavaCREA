package curso.demo17_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo01_Matcher {
    public static void main(String[] args) {
        String hola = "hola";
        String arroba = "arroba";
        String a = "a";

        String regex1 = "a"; // ^a$

        matches(hola, regex1);
        matches(arroba, regex1);
        matches(a, regex1);

        Pattern pregex1 = Pattern.compile(regex1);
        Matcher mhola = pregex1.matcher(hola);
        if (mhola.matches()) {
            System.out.println(hola + " Coincide con " + regex1);
        } else {
            System.out.println(hola + " No Coincide " + regex1);
        }

        if (mhola.find()) {
            System.out.println(hola + " Contiene " + regex1);
        } else {
            System.out.println(hola + " No Contiene " + regex1);
        }

        System.out.println();
        System.out.println("Find: ");
        find(hola, "a");
        find(arroba, "a");
        find(a, "a");

        System.out.println();
        find(hola, "^a");
        find(arroba, "^a");
        find(a, "^a");

        System.out.println();
        find(hola, "a$");
        find(arroba, "a$");
        find(a, "a$");

        System.out.println();
        System.out.println("Metacharacters");
        find("Los ángeles", "[Ll][ao]s");
        find("miraban las palomas", "[Ll][ao]s");
        find("Hola a todos", "[Ll][ao]s");


        System.out.println("Ejericicio 1-A:");
        find("12345678-F", "\\d\\d\\d\\d\\d\\d\\d\\d-[a-zA-Z]");
        find("aaaa12345678-FFFF", "\\d\\d\\d\\d\\d\\d\\d\\d-[a-zA-Z]");
        matches("12345678-F", "\\d\\d\\d\\d\\d\\d\\d\\d-[a-zA-Z]");
        matches("aaaa12345678-FFFF", "\\d\\d\\d\\d\\d\\d\\d\\d-[a-zA-Z]");

        System.out.println("Ejericicio 1-B:");
        matches("2010-01-01 00:00:00",
                "\\d\\d\\d\\d-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d");

        System.out.println("Ejericicio 1-C:");
        matches("hola", "\\w\\w\\w\\w");
        matches("h0la", "\\w\\w\\w\\w");
        matches("h_la", "\\w\\w\\w\\w");

        System.out.println();
        System.out.println("Cuantificadores");
        matches("12345678-F", "\\d{8}-[a-zA-Z]");
        matches("2010-01-01 00:00:00",
                "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}");
        matches("2010-50-50 30:99:99",
                "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}");
        matches("hola", "\\w{4}");

        System.out.println();
        matches("Hola", "[^aeiou]*");
        matches("HHHH", "[^aeiou]*");
        matches("  0w0 0rw", "[^aeiou]*");
        matches("?&@$|❤", "[^aeiou]*");

        System.out.println();
        matches("Hola", "[\\w&&[^a]]+");
        matches("HHHH", "[\\w&&[^a]]+");
        matches("Hol todos", "[\\w&&[^a]]+");
        matches("Perro", "[\\w&&[^a]]+");
        matches("  0w0 0rw", "[\\w&&[^a]]+");
        matches("?&@$|❤", "[\\w&&[^a]]+");

        System.out.println();
        matches("Hola", "[\\w&&[^a]]+a[\\w&&[^a]]+");
        matches("cómo mola", "[\\w&&[^a]]+a[\\w&&[^a]]+");
        matches("trapo", "[\\w&&[^a]]+a[\\w&&[^a]]+");
        matches("casette", "[\\w&&[^a]]+a[\\w&&[^a]]+");
        matches("barato", "[\\w&&[^a]]+a[\\w&&[^a]]+");
        matches("calabazas", "[\\w&&[^a]]+a[\\w&&[^a]]+");

        System.out.println();
        matches("it's true", ".*([tT]rue|[fF]alse).*");
    }

    public static void matches(String string, String regex) {
        System.out.print(string);
        if (!string.matches(regex)){
            System.out.print(" no");
        }
        System.out.println(" coincide con " + regex);
    }

    public static void find(String string, String regex) {
        System.out.print(string);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        if (!matcher.find()){
            System.out.print(" no");
        }
        System.out.println(" contiene " + regex);
    }
}

























