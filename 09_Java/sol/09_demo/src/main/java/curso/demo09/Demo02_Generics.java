package curso.demo09;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Demo02_Generics {

    public static void main(String[] args) {
        List<String> list = new LinkedList<String>();
        list.add("Hola");
        list.add("Mundo");

        printList(list);

        List<Integer> list2 = new LinkedList<Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(2);

        printListInteger(list2);

        // Varios Genéricos
        Map<Integer, String> map = new HashMap<Integer, String>();

        System.out.println("Puntos");
        Point<Integer> point = new Point<>(3, 5);
//        Point<String> point2 = new Point<>("Hello", "World");

        System.out.println("Legacy");
        printNonGenericList(list2);
        printListInteger(list2);
    }

    public static void printList(List<String> list) {
        for (String text : list) {
            System.out.println(text);
        }
    }

    public static void printListInteger(List<Integer> list) {
        for (Integer number : list) {
            System.out.println(number);
        }
    }

    public static void printNonGenericList(List list) {
        for (Object o : list) {
            System.out.println(o);
        }

        list.add("Trolling time!");
    }
}
class Point<T extends Number> {
    T x,y;

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }

    public <U extends Number> Point<U> convertTo(Class<U> clazz) throws Exception{
        Constructor<U> constructor = clazz.getConstructor(String.class);
        U newx = constructor.newInstance(x.toString());
        U newy = constructor.newInstance(y.toString());
        return new Point<U>(newx, newy);
    }
}
