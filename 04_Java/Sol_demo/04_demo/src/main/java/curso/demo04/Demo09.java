package curso.demo04;

public class Demo09 {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("Continue");
        int suma = 0;
        for (int i = 0; i <= 50; i++) {
            if (i % 5 != 0) {
                continue;
            }

            System.out.println(" - " + i);
            suma += i;

            if (suma >= 30) {
                break;
            }
        }

        System.out.println("");
        System.out.println("labels");
        int i = -1;

        external:
        while (i < 10) {
            i++;
            System.out.println("");

            for (int j = 0; j < 10; j++) {
                System.out.print(i);

                if (i * j > 40) {
                    continue external;
                }
                
                System.out.print("e");
            }

        }
    }

}
