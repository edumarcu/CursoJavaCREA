package curso.demo08;

public class Unchecked {

    public static void main(String[] args) {
        printText("Hola");
        try {
            printText(null);
        } catch (NullPointerException e) {
            System.out.println("Null Error");
        }
    }

    public static void printText(String text) {
        if (text == null) {
            // Extiende de RuntimeException
            throw new NullPointerException();
        }

        System.out.println(text);
    }

}
