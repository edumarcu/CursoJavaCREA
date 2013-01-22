package curso.demo08;

/**
 * Para Runtime Exceptions
 * @author EM
 */
public class Unchecked {
    public static void main(String[] args) {
        try {
            printText(null);
        } catch (NullPointerException e){
            System.err.println("Exception: " + e);
        }
    }
    
    // como exteiende de una que es unchecked no hace falta throws
    public static void printText(String text) {
        if (text == null) {
            throw new NullPointerException();
        }
        
        System.out.println(text);
    }
}
