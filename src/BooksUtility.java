import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BooksUtility {
    private DB db;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    BooksUtility(DB db) {
        this.db = db;
    }

    public void createBook() {
        try {
            String name, author, genre;
            int count = -1;
            System.out.println("Create new book:");
            System.out.print("Enter name: ");
            name = br.readLine();
            System.out.print("Enter author: ");
            author = br.readLine();
            System.out.print("Enter book count: ");
            count = Integer.parseInt(br.readLine());
            if (count < 0) {
                count = 0;
            }
            System.out.print("Enter genres(Seperate with ','): ");
            genre = br.readLine();
            Book newBook = db.createBook(name, author, count, genre);
            System.out.println(newBook.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getBook() {
        try {
            String id;
            System.out.println("Get book details:");
            System.out.print("Enter book id: ");
            id = br.readLine();
            Book book = db.readBookByField("id", id);
            System.out.println(book.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBook() {
        try {
            String id, name, author, genre;
            int count = -1;
            System.out.println("Update book:");
            System.out.print("Enter book id: ");
            id = br.readLine();
            System.out.print("Enter name: ");
            name = br.readLine();
            System.out.print("Enter author: ");
            author = br.readLine();
            System.out.print("Enter book count: ");
            String countInput = br.readLine();
            if (!countInput.isBlank())
                Integer.parseInt(countInput);
            if (count < 0) {
                count = 0;
            }
            System.out.print("Enter genres(Seperate with ','): ");
            genre = br.readLine();
            Book book = db.updateBook(id, name, author, count, genre);
            System.out.println(book.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteBook() {
        try {
            String id;
            System.out.println("Delete book:");
            System.out.print("Enter book id: ");
            id = br.readLine();
            db.deleteBook(id);
            System.out.println("Deleted book with id: " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAllBooks() {
        try {
            System.out.println("All book details:");
            ArrayList<Book> books = db.getAllBooks();
            books.forEach((book) -> System.out.println(book.toString()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
