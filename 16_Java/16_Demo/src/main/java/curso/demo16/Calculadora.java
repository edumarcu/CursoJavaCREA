package curso.demo16;

/**
 * Test de Unidad
 * @author EM
 */
public class Calculadora {

    private int a, b, res;

    public void add() {
        res = a + b;
    }

    public void sub() {
        res = a - b;
    }

    public void prod() {
        res = a * b;
    }

    public void div() {
        res = a / b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getRes() {
        return res;
    }
}
