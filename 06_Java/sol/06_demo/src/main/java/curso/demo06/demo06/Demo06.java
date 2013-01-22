package curso.demo06.demo06;

import java.lang.reflect.Array;

public class Demo06 {

    public static void main(String[] args) {

        // Conversiones
        int i = 5;
        Integer io = i;
        io = 5;
        int j = io;

        io = Integer.valueOf(i);
        io = new Integer(i);

        j = io.intValue();

        // Polimorfismo
        printInteger((Integer) i);
        printInteger(io);

        // Arrays
        int[] array = {1,2,3};
        System.out.println("Class: " + array.getClass());
        System.out.println("Array is Object?? " + array instanceof Object);

        array.clone();

        char[] arr2 = {};

        // System.out.println(array.getClass() == arr2.getClass());


        // ==
        System.out.println(" == ");
        System.out.println(((Integer) 5).equals(5)); // true

        Integer i1 = 5;
        Integer i2 = 5;
        System.out.println(i1 == i2); // true

        i1 = 1000000;
        i2 = 1000000;
        System.out.println(i1 == i2); // falsex
    }

    public static void printInteger(int i) {
        System.out.println("int: " + i);
    }

    public static void printInteger(Integer i) {
        System.out.println("INTEGER: " + i);
    }

}
