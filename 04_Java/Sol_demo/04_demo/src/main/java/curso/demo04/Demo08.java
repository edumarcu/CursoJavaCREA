package curso.demo04;

public class Demo08 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("While");
        int i = 0;
        while (i < 10) {
            System.out.println(" - " + i);
            i++;
        }

        i = 0;
        while (true) {
            System.out.println(" - " + i);
            if (i++ > 10) {
                break;
            }
        }

        System.out.println("");
        System.out.println("Do While");
        i = 0;
        do {
            System.out.println(" - " + i++);
        } while (i > 10);


        System.out.println("");
        System.out.println("For");
        for (int j = 0; j < 10; j++) {
            System.out.println(" - " + j);
        }
    }

}
