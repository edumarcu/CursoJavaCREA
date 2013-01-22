package curso.ej03_02;

// Tipos primitivos en java

import java.math.BigDecimal;

// http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
//
// Complemento a 2
// http://en.wikipedia.org/wiki/Two's_complement
public class App {

    public static void main(String[] args) {
        // 127 + 1
        //   01111111 ->  127
        // + 00000001 ->    1
        // -------------------
        //   10000000 -> -128

        // 150 to byte
        // v--------------------------signo
        // 00000000 10010110 ->  150
        //          10010110 -> -106
        //          ^-----------------signo
        // 129 to byte
        // 00000000 10000001 -> 129
        //          10000001 -> -127
        System.out.println("129 to byte");
        System.out.println("-> " + (byte) 150);

        // 40.000 to integers
        byte b = (byte) 40000;
        short s = (short) 40000;
        int i = 40000;
        long l = 40000;

        System.out.println("40.000 to integer:");
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);

        // 3.000.000.000 to integers
        b = (byte) 3000000000l;
        s = (short) 3000000000l;
        i = (int) 3000000000l;
        l = 3000000000l;

        System.out.println("3.000.000.000 to integer:");
        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);

        //
        // Floats
        //

        // printing with 1 decimal
        System.out.println("Printing 4.95:");
        System.out.printf("%.1f\f\n",4.95f);
        System.out.println((int)(4.95 * 10) / 10f);


        // Checking 4.95 * 100 = 495
        System.out.println("4.95 * 100 ¿==? 495");
        System.out.println(4.95f * 100f == 495f);
        System.out.println("4.95 * 100 = " + (4.95f * 100f));
        System.out.println("4.95 = " + 4.95f);
        System.out.printf("4.95 = %.10f\n", 4.95f);
        BigDecimal bd = new BigDecimal("4.95");
        System.out.println("4.95 = " + bd.toString());


        //
        // Boolean
        //

        // true -> int
        // No convertible
        // System.out.println("true -> int: " + (byte) true);
        // System.out.println("int -> boolean: " + (boolean) 1);

        //
        // Chars
        //

        // 65 -> char
        System.out.println("65: " + (char) 65);
        // 'A' -> int
        System.out.println("A: " + (int) 'A');

        //
        // Literals
        //

        System.out.println();
        System.out.println("Integers:");
        System.out.println("35: " + 35);
        System.out.println("0xFF: " + 0xFF);
        System.out.println("035: " + 035);
        // System.out.println("035: " + 0b100); java >= 1.7

        System.out.println();
        System.out.println("Floats:");
        System.out.println("4.95d: " + 4.95d);
        System.out.println("4.95f: " + 4.95f);
        System.out.println("495e-2: " + 495e-2);

        System.out.println();
        System.out.println("Char:");
        System.out.println("'A': " + 'A');
        System.out.println("'\\t': " + '\t' + ".");
        System.out.println("'\\u00F1': " + '\u00F1');

    }
}





