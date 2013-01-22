package curso.demo07;

public class Demo01 {

//    private static int numero = 0;
    public static int numero = 0;

    public int numero2 = 12;

    public static void main(String[] args) {
        System.out.println("Static");

        Demo01 d1 = new Demo01();
        d1.numero = 12;

        Demo01 d2 = new Demo01();
        d2.numero = 24;

        System.out.println("d1.numero " + d1.numero);
        System.out.println("d2.numero " + d2.numero);

        System.out.println("Acceso desde clase");
        Demo01.numero = 100;
        System.out.println("d1.numero " + d1.numero);

        System.out.println("Static Herencia");
        Demo01Child.printNumero();

//        numero2 = 23;
    }

    public static String foo() { return "FOO"; }
}

class Demo01Child extends Demo01 {

    public static int numero = 50;

    public static void printNumero() {
        System.out.println("Numero desde hija 1: " + Demo01.numero);
        System.out.println("Numero desde hija 2: " + Demo01Child.numero);

        System.out.println("Numero = 33 ");
        Demo01.numero = 33;
        System.out.println("Numero desde hija 1: " + Demo01.numero);
        System.out.println("Numero desde hija 2: " + Demo01Child.numero);

        System.out.println("FOO");
        System.out.println("FOO desde madre "+ Demo01.foo());
        System.out.println("FOO desde hija " + Demo01Child.foo());
    }

    public static String foo() { return Demo01.foo() + " BAR"; }

}
