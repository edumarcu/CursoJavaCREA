package curso.demo07;


public class Demo11_2 {
    public static void main(String[] args) {
        Demo11.Demo11InnerStatic d1 = new Demo11.Demo11InnerStatic();
        Demo11 d11 = new Demo11();
        Demo11.Demo11Inner d2 = d11.new Demo11Inner();
    }
}