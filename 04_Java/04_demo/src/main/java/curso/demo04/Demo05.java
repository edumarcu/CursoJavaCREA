package curso.demo04;

import static java.lang.System.out;

public class Demo05 {

    public static void main(String[] args) {
        System.out.println("Operadores lógicos");

        out.println("");
        out.println(" < > <= => ");
        out.println(" 2 < 3 = " + (2 < 3));
        out.println(" 2 > 3 = " + (2 > 3));
        out.println(" 2 < 2 = " + (2 < 2));
        out.println(" 2 <= 2 = " + (2 <= 2));

        out.println("");
        out.println(" == != ");
        out.println(" 2 == 3 = " + (2 == 3));
        out.println(" 2 != 3 = " + (2 != 3));
        out.println(" \"2\" == \"2\" = " + ("2" == "2"));
        out.println(" \"ab\" == \"a\" + \"b\" = " + ("ab" == "a" + "b"));
        out.println(" \"ab\" == new String(\"ab\") = " + ("ab" == new String("ab")));
        Point p1 = new Point(3, 5);
        Point p2 = new Point(3, 5);
        Point p3 = p1;
        out.println(" p1 == p2 = " + (p1 == p2));
        out.println(" p1 == p3 = " + (p1 == p3));

        out.println("");
        out.println(" instanceof ");
        Object o = p1;
        out.println(" o instanceof String " + (o instanceof String));
        out.println(" o instanceof Point " + (o instanceof Point));
        out.println(" o instanceof Object " + (o instanceof Object));

        out.println("");
        out.println(" & ^ | ");
        //   0101
        // & 0011
        // -------
        //   0001
        out.println(" 5 & 3 = " + (5 & 3));
        //   0101
        // & 0011
        // -------
        //   0110
        out.println(" 5 ^ 3 = " + (5 ^ 3));
        //   0101
        // | 0011
        // -------
        //   0111
        out.println(" 5 | 3 = " + (5 | 3));

        out.println("");
        out.println(" & | && ||");
        out.println(" no() & yes() = " + (no() & yes()));
        out.println(" no() && yes() = " + (no() && yes()));
    }

    public static boolean yes() {
        out.println("YES");
        return true;
    }

    public static boolean no() {
        out.println("NO");
        return false;
    }

}
