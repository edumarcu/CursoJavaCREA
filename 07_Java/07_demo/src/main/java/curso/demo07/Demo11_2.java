package curso.demo07;

/**
 * Subclases como elementos de clases
 * @author EM
 */
public class Demo11_2 {
    
    public static void main(String[] args) {
        // 2 instancias aqui
        
        Demo11 demo11 = new Demo11();
        Demo11.Demo11Subclass1 demo11Subclass1 = demo11.new Demo11Subclass1();
        Demo11.Demo11SubclassStatic demo11SubclassStatic = new Demo11.Demo11SubclassStatic();
    }
    
}
