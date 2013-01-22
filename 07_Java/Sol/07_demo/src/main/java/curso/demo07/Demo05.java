package curso.demo07;

public class Demo05 {

    public static void main(String[] args) {

        System.out.println("Varargs");
        imprimir(1,2,3,4,5,6,7,8);
        imprimir();
        imprimir(new int[]{10, 20, 30});
//        imprimir(new Integer[]{10, 20, 30});
    }

    public static void imprimir(int... numeros) {
        System.out.println("Imprimir int");
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
    }
/*
    public static void imprimir(Integer... numeros) {
        System.out.println("Imprimir Integer");
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
    }
/*
    public static void imprimir(int numero, int... numeros) {
        System.out.println("Imprimir 2:" + numero);
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
    }

    public static void imprimir(Integer numero, int... numeros) {
        System.out.println("Imprimir 3:" + numero);
        for (int i : numeros) {
            System.out.println(" * " + i);
        }
    }
*/
}
