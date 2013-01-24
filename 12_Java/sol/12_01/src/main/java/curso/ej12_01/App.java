package curso.ej12_01;

public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "Preparing Pasta!" );

        Thread t01 = new Thread(new R01Pasta());
        Thread t03 = new Thread(new R03Bolognese());
        Thread t04 = new Thread(new R04TellJokes());

        t01.start();
        t03.start();
        t04.start();

        t01.join();
        t03.join();

        t04.interrupt();

        System.out.println("A Comer!");
    }
}
