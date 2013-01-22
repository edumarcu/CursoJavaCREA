package curso.demo07;

public class Demo12 {
/*
    static class ComparadorAnonimo implements Comparador {
        public boolean mayorQue(int a, int b) {
            return a - b > 0;
        }
    }
*/
    static Comparador c1 = new Comparador(){
        @Override
        public boolean mayorQue(int a, int b) {
            return a - b > 0;
        }
    };


    public static void main(String[] args) {
        Comparador c2 = new Comparador() {
            public boolean mayorQue(int a, int b) {
                return a > b;
            }
        };

        System.out.println("3 > 5 : " + c1.mayorQue(3, 5));
    }
}

interface Comparador {
    boolean mayorQue(int a, int b);
}
