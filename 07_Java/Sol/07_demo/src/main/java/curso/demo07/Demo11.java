package curso.demo07;

public class Demo11 {

    public static void main(String[] args) {
        Demo11InnerStatic d1 = new Demo11InnerStatic();

        Demo11 d11 = new Demo11();
        Demo11Inner d2 = d11.new Demo11Inner();
    }

    public int foo;

    public static int bar;

    public class Demo11Inner{
        public void sayFoo() {
            System.out.println(foo);
            System.out.println(bar);
        }
    }

    public static class Demo11InnerStatic{
        public void sayFoo() {
            System.out.println(bar);
        }
    }
}
