package curso.demo16;

public class Calculator {

    private int a,b,res;

    // Operations

    public void add(){
        res = a + b;
    }

    public void del(){
        res = a - b;
    }

    public void mul(){
        res = a * b;
    }

    public void div(){
        res = a / b;
    }

    // Getters and Setters

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
