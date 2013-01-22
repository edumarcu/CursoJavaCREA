package curso.demo04;

public class Demo01 {

    public static void main(String[] args) {
        Demo01 demo = new Demo01();
        demo.method1(45);
        demo.method1(15);
        System.out.println("a = " + demo.a);
        System.out.println("b = " + demo.b);
    }

    int a;
    int b;

    public void method1(int a) {
        this.a = a;
        this.b = this.b + this.a;
    }

}
