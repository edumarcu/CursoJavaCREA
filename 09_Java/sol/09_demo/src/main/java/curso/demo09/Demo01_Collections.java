package curso.demo09;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Demo01_Collections {
    public static void main(String[] args) {
        // Listas
        List list = new ArrayList();
        String tre = "tré";
        list.add(tre);
        list.add("Uno");
        list.add("Uno");
        list.add(new Integer(2));
        list.remove(new String("Uno"));
        list.add(tre);

        String texto = (String) list.get(0);

        System.out.println("List: " + list);

        // Set
        Collection set = new HashSet();
        set.add(tre);
        set.add("Uno");
        set.add("Uno");
        set.add(new Integer(2));
        set.remove(new String("Uno"));
        set.add(tre);

        System.out.println("Set: " + set);

        // Map
        Map map = new HashMap();
        Object muno = "Uno";
        Object mdos = new Integer(2);
        Object mtre = "tré";
        map.put(1, muno);
        map.put(2, mdos);
        map.put(3, mtre);
        map.put(4, muno);
        map.put(3, muno);

        System.out.println("Map: " + map);

        // Deque
        System.out.println("Deque");
        Deque deque = new LinkedList();
        deque.push("uno");
        deque.push("dos");
        deque.addFirst("tres");
        System.out.println("Deque: " + deque);
        System.out.println("Peek:" + deque.peek());
        deque.pop();
//        deque.poll();
//        deque.pollFirst();
//        deque.removeFirst();
        System.out.println("Pop: ");
        System.out.println("Peek:" + deque.peek());

        deque.pollLast();
        System.out.println("Poll Last: ");

        System.out.println("Deque: " + deque);

        deque.addLast("foo 1");
        deque.add("foo 2");
        System.out.println("Deque: " + deque);

    }
}
