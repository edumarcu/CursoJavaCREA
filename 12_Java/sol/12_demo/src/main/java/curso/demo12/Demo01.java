package curso.demo12;

public class Demo01 {

    public static void main(String[] args) {

        Thread current = Thread.currentThread();

        System.out.println("Waiting");
        try{
            current.sleep(5000);
        } catch (Exception e) {
            System.out.println("Interrupted");
        }
        System.out.println("Finishing");

    }
}
