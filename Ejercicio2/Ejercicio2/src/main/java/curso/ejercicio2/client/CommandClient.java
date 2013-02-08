package curso.ejercicio2.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import curso.ejercicio2.commons.*;
import java.util.List;

/**
 * Client for Executing Library Commands
 * @author EM
 */
public class CommandClient {

    private static Socket socket;
    private static BufferedOutputStream bos;
    private static ObjectOutputStream out;
    private static BufferedInputStream bis;
    private static ObjectInputStream in;
    
    public void createConexion() throws Exception {

        System.out.println("Creating client socket...");
        socket = new Socket("127.0.0.1", 3450);
        //System.out.println("-> socket");
        bos = new BufferedOutputStream(socket.getOutputStream());
        //System.out.println("-> bos");
        out = new ObjectOutputStream(bos);
        //System.out.println("-> out");
        
        out.writeObject("");
        out.flush();
        
        bis = new BufferedInputStream(socket.getInputStream());
        //System.out.println("-> bis");
        in = new ObjectInputStream(bis);
        //System.out.println("-> in");
       
        String message = (String) in.readObject();
        //System.out.println("Conexion stablished: " + message);
        
        //System.out.println("OK!");

    }

    public boolean addBook(Book book) throws Exception {
        AddBookCommand command = new AddBookCommand(book);
        out.writeObject(command);
        out.flush();
        command = (AddBookCommand) in.readObject();
        if (command.isOk()) {
            System.out.println("Book added: " + command.getBook());
        } else {
            System.out.println("Book NOT added: " + command.getBook());
        }

        return command.isOk();
    }

    public boolean removeBook(Book book) throws Exception {
        RemoveBookCommand command = new RemoveBookCommand(book);
        out.writeObject(command);
        out.flush();
        command = (RemoveBookCommand) in.readObject();
        if (command.isOk()) {
            System.out.println("Book removed: " + command.getBook());
        } else {
            System.out.println("Book NOT removed: " + command.getBook());
        }

        return command.isOk();
    }

    public boolean containsBook(Book book) throws Exception {
        ContainsBookCommand command = new ContainsBookCommand(book);
        out.writeObject(command);
        out.flush();
        command = (ContainsBookCommand) in.readObject();
        if (command.isOk()) {
            System.out.println("Book contained: " + command.getBook());
        } else {
            System.out.println("Book NOT contained: " + command.getBook());
        }

        return command.isOk();
    }

    public List<Book> list() throws Exception {
        ListBooksCommand command = new ListBooksCommand();
        out.writeObject(command);
        out.flush();
        command = (ListBooksCommand) in.readObject();

        System.out.println("Books listed: ");
        for (Book b : command.getBooks()) {
            System.out.println("-> " + b);
        }

        return command.getBooks();
    }


}
