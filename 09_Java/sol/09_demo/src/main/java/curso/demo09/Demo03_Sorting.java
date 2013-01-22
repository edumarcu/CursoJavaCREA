package curso.demo09;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo03_Sorting {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("Sort a List");
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(1);
        integers.add(5);
        integers.add(24);
        integers.add(3);
        System.out.println(integers);

        Collections.sort(integers);
        System.out.println(integers);

        System.out.println("");
        System.out.println("Sorted Set");
        SortedSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(1);
        set.add(5);
        set.add(24);
        set.add(3);
        System.out.println(set);

        System.out.println("");
        System.out.println("Sorted Map");
        Map<Integer, String> map = new TreeMap<>();
        map.put(10, "aaaa");
        map.put(1, "bbbbb");
        map.put(5, "ccccc");
        map.put(24, "ddddd");
        map.put(3, "eeeee");
        System.out.println(map);

        System.out.println("");
        System.out.println("Sorted Map: Point");
        Map<SortablePoint<Integer>, String> points = new TreeMap<>();
        points.put(new SortablePoint<>(3,5), "mi casa");
        points.put(new SortablePoint<>(0,0), "origen");
        System.out.println(points);

        Comparator<SortablePoint<Integer>> reverse = new Comparator<SortablePoint<Integer>>() {
            @Override
            public int compare(SortablePoint<Integer> o1, SortablePoint<Integer> o2) {
                return -1 * o1.compareTo(o2);
                // return o2.compareTo(o1);
            }
        };

        System.out.println("");
        System.out.println("Sorted Map: Points Reverse");
        Map<SortablePoint<Integer>, String> pointsreverse = new TreeMap<>(reverse);
        pointsreverse.putAll(points);
        System.out.println(pointsreverse);

        System.out.println("");
        System.out.println("Acceso");
        SortablePoint<Integer> origen = new SortablePoint<>(0,0);
        String nombre = points.get(origen);
        System.out.println("El punto " + origen + " es " + nombre);

        Map<SortablePoint<Integer>, String> pointsHash = new HashMap<>(points);
        nombre = pointsHash.get(origen);
        System.out.println("El punto " + origen + " es " + nombre);
        
        //List<Integer> integers;

        // Lista de Numbers, devuelve un Number sí o sí.
        //                   puedo añadir cualquier Number.
        // List<Number> numbers = (List<Number>) integers;

        // Lista de una clase (que no conozco) que extiende de Number.
        //    devuelve objetos de esa clase que extiende de Number.
        //    sólo puedo añadir ese tipo que exiende de Number.
        List<? extends Number> numberchilds = integers;
        // numberchilds = new LinkedList<Integer>();
        // numberchilds.add(new Integer(5));
    }
}
class SortablePoint<T extends Number> implements Comparable<SortablePoint<T>>{
    T x,y;

    public SortablePoint(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public String toString() {
        return "<" + x + "," + y + ">";
    }

    public double distanceToOrigin() {
        double xd = x.doubleValue();
        double yd = y.doubleValue();

        return Math.hypot(xd, yd);
    }

    @Override
    public int compareTo(SortablePoint<T> o) {

        return Double.compare(distanceToOrigin(), o.distanceToOrigin());

//        return (int) Math.signum(distanceToOrigin() - o.distanceToOrigin());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.x);
        hash = 13 * hash + Objects.hashCode(this.y);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SortablePoint<T> other = (SortablePoint<T>) obj;
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        return true;
    }


}
