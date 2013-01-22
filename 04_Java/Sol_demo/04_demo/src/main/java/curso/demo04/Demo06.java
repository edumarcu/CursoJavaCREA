package curso.demo04;

import static java.lang.System.out;

public class Demo06 {

    public static void main(String[] args) {
        System.out.println("Operadores abreviados");

        out.println("");
        out.println(" += -= *= /=  %= <<= >>= >>>= &= ^= |=");
        int a = 3;
        System.out.println("a = " + a);
        a += 2; // a = a + 2;
        System.out.println("a += 2; a = " + a);
        a %= 3; // a = a %3;
        System.out.println("a %= 3; a = " + a);
    }

}
