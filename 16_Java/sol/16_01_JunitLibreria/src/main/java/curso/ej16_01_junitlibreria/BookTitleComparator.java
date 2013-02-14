package curso.ej16_01_junitlibreria;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

    public int compare(Book o1, Book o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }

}
