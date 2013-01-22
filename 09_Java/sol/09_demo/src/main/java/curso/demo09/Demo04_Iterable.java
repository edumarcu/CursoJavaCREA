package curso.demo09;

import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedList;

public class Demo04_Iterable {

    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Array ");
        int[] array = {1,2,3,4};
        for (int i : array) {
            System.out.println(" * " + i);
        }

        System.out.println("");
        System.out.println("List ");
        Collection<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        /*
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println(" * " + i);
        }
        */
        for (int i : list) {
            System.out.println(" * " + i);
        }

        System.out.println("");
        System.out.println("Array es iterable? "
                + (Iterable.class.isAssignableFrom(array.getClass())));

    }

}
