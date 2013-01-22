package curso.demo07;

/**
 * Subclases como elementos de clases
 * @author EM
 */
public class Demo11 {
    
    public static void main(String[] args) {
        // 2 instancias aqui
        Demo11 demo11 = new Demo11();
        Demo11Subclass1 demo11Subclass1 = demo11.new Demo11Subclass1();
        Demo11SubclassStatic demo11SubclassStatic = new Demo11SubclassStatic();
    }
    
    public int foo;
    
    public static int bar;
    
    public class Demo11Subclass1{
        public void sayFoo() {
            System.out.println(foo);
            System.out.println(bar);
        }
    }
    
    public static class Demo11SubclassStatic{
        public void sayFoo() {
            System.out.println(bar);
        }
    }
}
