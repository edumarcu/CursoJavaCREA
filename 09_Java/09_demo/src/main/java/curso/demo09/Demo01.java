package curso.demo09;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Deque;

/**
 * Collections
 * @author EM
 */
public class Demo01 {
    public static void main(String[] args) {
        // Listas
        List l = new ArrayList();
        String tre = "tré";
        l.add(tre);
        l.add("Uno");
        l.add(new Integer(2));
        l.remove(new String("Uno"));   // la igualdad se hace con equals, solo el 1º
        l.add(tre);
        
        System.out.println("ArrayList: " + l);
        System.out.println();
        
        // Conjuntos
        HashSet hs = new HashSet();
        hs.add(tre);
        hs.add("Uno");
        hs.add("Uno");
        hs.add(new Integer(2));
        hs.remove("Uno");
        hs.add(tre);
        
        System.out.println("HashSet: " + hs);
        System.out.println();
        
        // Mapas
        HashMap m = new HashMap();
        Object muno = "uno";
        Object mdos = new Integer(2);
        Object mtre = new String("tré");
        
        m.put(1, muno);
        m.put(2, mdos);
        m.put(3, mtre);
        m.put(4, muno);
        m.put(3, muno);
        
        m.remove(2);
        
        System.out.println("HashMap: " + m);
        System.out.println();
        
        // Colas
        Deque dq = new LinkedList();
        dq.push("Uno");
        dq.push("Dos");
        dq.push(new String("Tres"));
        
        System.out.println("Deque: " + dq);
        System.out.println("\tpeek: " + dq.peek());
        
        System.out.println("\tpop: " + dq.pop());
        System.out.println("Deque: " + dq);
        
        System.out.println("\tpoll: " + dq.pop());
        System.out.println("Deque: " + dq);
        System.out.println();
    }
    
}
