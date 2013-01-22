package curso.demo07;

public class Demo06 {

    public static void main(String[] args) {

        System.out.println("Varargs Clases");
        A a1 = new A();
        A a2 = new A();
        B b1 = new B();
        A a3 = b1;

        imprimir(a1, a2, b1, a3);
//        imprimir(new A[]{a1, a2, b1, a3});

        imprimir(b1, a2, a1, a3);
    }

    public static void imprimir(A... objs) {
        System.out.println("Imprimir 1");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
    }
/*
    public static void imprimir(A obj, A... objs) {
        System.out.println("Imprimir 2");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
    }
*/
    public static void imprimir(B obj, A... objs) {
        System.out.println("Imprimir 3");
        for (A a1 : objs) {
            System.out.println(" * " + a1);
        }
    }
}

class A {}
class B extends A {}
