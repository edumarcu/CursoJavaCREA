package curso.ej12_01;

public class R03Bolognese implements Runnable {

    public void run() {
        System.out.println("Pochando la Cebolla");

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) { return; }

        System.out.println("Dorando la carne Picada");

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) { }

        System.out.println("Echando Tomate");

        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) { }


        System.out.println("Echando Orégano, Albahaca y Pimienta");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) { }

        System.out.println("La salsa está lista");
    }

}
