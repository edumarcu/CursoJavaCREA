package curso.demo04;

public class Demo02 {

    public static void main(String[] args) {
        Demo02 demo = new Demo02();
        System.out.println("a: " + demo.a);

        // int b; // Al no estar inicializada da error
        int b = 10;
        System.out.println("b: " + b);

        int[] c = null;
        System.out.println("c: " + c);
    }

    int a;

}
