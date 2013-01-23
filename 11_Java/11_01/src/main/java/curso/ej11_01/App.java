package curso.ej11_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Drawing Rectangles asking dimensions, System.in
 * @Author EM
 */
public class App {
    public static void main( String[] args ) throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        System.out.println("Hello, I draw Rectangles, which dimensions "
                + "do you want?");
        System.out.print("Height? -> ");
        String lineH = in.readLine();
        int h = Integer.parseInt(lineH);
        System.out.print("Width? -> ");
        String lineW = in.readLine();
        int w = Integer.parseInt(lineW);

        System.out.println();
        System.out.println("Ok, let´s draw it! (" + lineH + "x" + lineW +")");
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
    }
}
