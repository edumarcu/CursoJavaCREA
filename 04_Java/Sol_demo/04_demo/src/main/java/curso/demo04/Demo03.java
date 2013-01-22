package curso.demo04;

import static java.lang.System.out;

public class Demo03 {

    public static void main(String[] args) {
        System.out.println("Operadores unarios");

        out.println("");
        out.println("++ y --");
        int a = 4; out.println("a = " + a);
        a++; out.println("a++; a = " + a);
        a--; out.println("a--; a = " + a);
        out.println("a++; a = " + a++);
        out.println("++a; a = " + ++a);
        out.println("a = " + a);


        out.println("");
        out.println("+ y -");
        int b = -a; out.println("b = -a ; b = " + b);
        int c = +a; out.println("c = +a ; c = " + c);


        out.println("");
        out.println("~ y !");
        byte d = 3; out.println("d = " + d);
        out.println("~d = " + ~d);
        boolean e = false; out.println("e = " + e);
        out.println("!e = " + !e);


        out.println("");
        out.println(" (tipo)");
        int f = 128; out.println("f = " + f);
        byte g = (byte) f; out.println("g = (byte) f = " + g);

    }

}
