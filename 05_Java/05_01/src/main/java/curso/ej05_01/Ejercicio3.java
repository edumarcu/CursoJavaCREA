package curso.ej05_01;

public class Ejercicio3 {

    public static void main(String[] args) {
        // TODO 05.01.3
        /*
         * Escriba un programa que indique si un número es capicúa.
         * Almacene inicialmente el número en un vector de enteros.
         *
         * Para el 45.654:
         * {4,5,6,5,4} = true
         */
        
        long[] v = new long[7];
        long n = 4567654;
        
        int i = 0;
        while (i < v.length) {
            v[i] = n % 10;
            n /= 10;
            i++;
        }
        
        boolean capicua = false;
        i = 0;
        while (i < (v.length) / 2) {
            capicua = v[i] == v[v.length - i - 1];
            System.out.println("v[i]= " + v[i] + " v[v.length - i - 1]= " + (v[v.length - i - 1]));
            i++;
            
            if (!capicua) {
                break;
            }
            
        }
        
        for (long j : v) {
          System.out.println(j + " ");
        }
        
        if (capicua) {
            System.out.println("Es capicua");
        }
    }
}
