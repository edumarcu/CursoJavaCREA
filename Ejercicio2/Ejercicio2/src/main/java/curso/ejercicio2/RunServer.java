package curso.ejercicio2;

import curso.ejercicio2.commons.Book;
import curso.ejercicio2.commons.Library;
import curso.ejercicio2.server.CommandServer;
import curso.ejercicio2.client.CommandClient;

public class RunServer {

    public static void main(String[] args) throws Exception {

        System.out.println("Iniciando servidor");
        Thread server = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    CommandServer.main(new String[]{});
                } catch (Exception e) {
                    System.err.println("Server Error: ");
                    e.printStackTrace(System.err);
                }
            }
        });
        server.setDaemon(true);
        server.start();
        Thread.sleep(1000);

        System.out.println();
        System.out.println("Iniciando Librería");
//      Por ahora solo creamos una, en el servidor, se podria hacer un commando de crear..
        CommandClient commandClient = new CommandClient();
        commandClient.createConexion();

        CommandClient library = commandClient;

        System.out.println();
        System.out.println("Añadiendo Libros");
        library.addBook(new Book("0 7475 5819 1", "Harry Potter and the philosopher's stone", 1997, "J. K. Rowling"));
        library.addBook(new Book("0 7475 3848 4", "Harry Potter and the chamber of secrets", 1998, "J. K. Rowling"));
        Book b1984 = new Book("978 0 140 81774 4", "Nineteen eighty-four", 1949, "George Orwell");
        library.addBook(b1984);
        library.addBook(new Book("35 221 2800 1", "Die unendliche geschichte", 1979, "Michael Ende"));
        library.addBook(new Book("0 345 39180 2", "The hitchhicker's guide to the galaxy", 1979, "Douglas Adams"));

        System.out.println();
        System.out.println("Libros:");
        for (Book book : library.list()) {
            System.out.println(book);
        }

        System.out.println();
        System.out.println("Contiene: " + b1984);
        System.out.println(library.containsBook(b1984));

        System.out.println();
        System.out.println("Borrando: " + b1984);
        System.out.println(library.removeBook(b1984));

        System.out.println();
        System.out.println("Libros:");
        for (Book book : library.list()) {
            System.out.println(book);
        }

//        String isbn = "35 221 2800 1";
//        System.out.println();
//        System.out.println("Find By ISBN: " + isbn);
//        System.out.println(library.findByISBN(isbn));
//
//        int year = 1979;
//        System.out.println();
//        System.out.println("Find By Year: " + year);
//        for (Book book : library.findByYear(year)) {
//            System.out.println(book);
//        }
//
//        String author = "J. K. Rowling";
//        System.out.println();
//        System.out.println("Find By Author: " + author);
//        for (Book book : library.findByAuthor(author)) {
//            System.out.println(book);
//        }
    }
}
