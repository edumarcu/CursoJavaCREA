/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.ej12_01;

/**
 *
 * @author Usuario
 */
public class JokesTeller implements Runnable {

    public static boolean tellJokes = true;

    @Override
    public void run() {

        while (tellJokes) {
            System.out.println("\t\tEre un torpedo pecador..");
        }
    }
}
