package curso.demo08;

public class Errors {

    public static void main(String[] args) {
        System.out.println("F(10) = " + fibonacci(10));
        try {
            System.out.println("F(1000000) = " + fibonacci(1000000));
        } catch (Error e) {
            System.out.println("Error calculando F(10)");
        }
    }

    public static long fibonacci(long n) {

        if (n <= 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
