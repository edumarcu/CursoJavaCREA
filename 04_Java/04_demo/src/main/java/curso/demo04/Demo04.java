package curso.demo04;

import static java.lang.System.out;

public class Demo04 {

    public static void main(String[] args) {
        System.out.println("Operadores matemáticos");

        out.println("");
        out.println("* / % + -");
        out.println("3 * 4 = " + (3 * 4));
        out.println("9 / 4 = " + (9 / 4));
        out.println("9 % 4 = " + (9 % 4));
        out.println("3 + 4 = " + (3 + 4));
        out.println("3 - 4 = " + (3 - 4));


        out.println("");
        out.println(" Precedencia ");
        out.println("3 * 4 + 9 = " + (3 * 4 + 9));
        out.println("9 + 3 * 4 = " + (9 + 3 * 4));
        out.println("(9 + 3) * 4 = " + ((9 + 3) * 4));

        out.println("");
        out.println(" Concatenación… ¡Ojo! ");
        out.println("'a' + 'b' + \"cd\" = " + 'a' + 'b' + "cd");
        Point p = new Point(3,5);
        out.println(" \"Punto \" + p = " + "Punto " + p);
        out.println(" \"3 + 4 = \" + 3 + 4= " + "3 + 4 = " + 3 + 4);
        out.println(3 + 4 + "<- 3 + 4");


        out.println("");
        out.println(" << >> >>> ");
        out.println(" 32 << 1 = " + ( 32 << 1));
        out.println(" -32 >> 2 = " + ( -32 >> 2));
        out.println(" -32 >>> 2 = " + ( -32 >>> 2));
    }

}
