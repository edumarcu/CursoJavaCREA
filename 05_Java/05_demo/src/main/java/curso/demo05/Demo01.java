package curso.demo05;

import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {

        int[] array = {3, 4, 5, 6, 7};
//        int[]j;
//        int k[];

        array = new int[5];

        System.out.println("i, posición 4 = " + array[4]);

        //          array 0  1  2  3
        array = new int[]{3, 4, 5, 6};

        System.out.println("Longitud de i = " + array.length);

        for (int j = 0; j < array.length; j++) {
            System.out.printf("[%d] = %d\n", j, array[j]);
        }

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        // System.out.println("array[100] :" + array[100]);


        // Arrays de referencias
        Point[] points = { new Point(1,1), new Point(3,5) };

        for (Point p : points) {
            System.out.println(p);
        }

        Point[][] points2 = new Point[3][2];
        points2[1] = new Point[4];
        points2[0] = points2[2];
        for (int i = 0; i < points2.length; i++) {
            for (int j = 0; j < points2[i].length; j++) {
                points2[i][j] = new Point(i, j);
            }
        }
        for (Point[] fila : points2) {
            for (Point p : fila) {
                System.out.print(p + " ");
            }
            System.out.println();
        }

        // Operaciones con arrays
        System.out.println("Copying");
        int[] numbers = {1, 2, 3};
        int[] temp = new int[6];
        for (int i = 0; i < numbers.length; i++ ) {
            temp[i] = numbers[i];
        }
        numbers = temp;
        System.out.println(Arrays.toString(numbers));

        //
        numbers = new int[]{1, 2, 3};
        temp = new int[6];
        System.arraycopy(numbers, 0, temp, 0, numbers.length);
        numbers = temp;
        System.out.println(Arrays.toString(numbers));

        //
        numbers = Arrays.copyOf(numbers, 6);
        System.out.println(Arrays.toString(numbers));

    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("< %d , %d >", x, y);
        }
    }

}
