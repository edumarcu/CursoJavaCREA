package curso.demo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Demo02 {
    public static void main( String[] args ) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        Scanner in = new Scanner(System.in);

        System.out.println("Hi, I'm Demo11_02, I can draw rectangles.");
        System.out.println("To start, tell me the width of the rectangle:");

        int width = in.nextInt();
        in.nextLine();

        System.out.println("Now, write the height of the rectangle:");

        int height = in.nextInt();
        in.nextLine();

        System.out.println("Drawing rectangle " + width + "x" + height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("# ");
            }
            System.out.println();
        }
    }
}
