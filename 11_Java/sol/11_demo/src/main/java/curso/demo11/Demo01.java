package curso.demo11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo01 {
    public static void main( String[] args ) throws IOException {

        System.out.println("Hola, soy Demo11, ¿Cómo te llamas?");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(reader);

        String name = in.readLine();

        System.out.println("Encantado de conocerte, " + name);
    }
}
