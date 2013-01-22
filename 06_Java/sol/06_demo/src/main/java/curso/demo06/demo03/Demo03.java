package curso.demo06.demo03;

public class Demo03 {

    public static void main(String[] args) {
        B b = new C();
    }

}


class A {

    private Logger madre = new Logger("Madre");

    public A() {
        System.out.println("Constructor Madre");
    }
}

class B extends A {

    private Logger hija = new Logger("Hija");

    public B() {
        System.out.println("Constructor Hija");
    }
}

class C extends B {

    private Logger nieta = new Logger("Nieta");

    public C() {
        System.out.println("Constructor Nieta");
    }
}

class Logger {
    public Logger(String name) { System.out.println(" Cargando Logger: " + name); }
}
