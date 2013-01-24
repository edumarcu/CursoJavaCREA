package curso.ej12_01;


public class R04TellJokes implements Runnable {

    private static String[] jokes = {
    "- Camarero, este plátano está blando. \n" +
    "- Pues dígale que se calle.",

    "- ¿Cómo se dice en congoleño: “Podríamos cenar unas setas”? \n" +
    "- Hongo propongo.",

    "‎- ¿El capitán?\n" +
    "- Por babor.\n" +
    "- Por babor, ¿el capitán?",

    "- Mamá, mamá, ¿porqué corre el abuelo?\n" +
    "- Calla, niño, y pásame otro cartucho.",

    "- ¿Qué se ve desde el edificio más alto de Toronto?\n" +
    "- Toronto to’, Toronto to’ entero."
    };

    public void run() {
        while (true) {
            int joke = (int) Math.floor(Math.random() * jokes.length);

            System.out.println("--");
            System.out.println(jokes[joke]);
            System.out.println("--");
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Interrupted");
                return;
            }
        }
    }

}
