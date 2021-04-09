import java.util.ArrayList;
import java.util.HashMap;

public class Database {
    private HashMap<String, User> users;
    private HashMap<String, Book> books;

    Database() {
        users = new HashMap<String, User>();
        books = new HashMap<String, Book>();
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> usersArray = new ArrayList<User>();
        users.forEach((key, val) -> usersArray.add(val));
        return usersArray;
    }

    public User getUserById(String id) {
        return users.get(id);
    }

    public User createUser(String name, String phone, String email, String address) {
        if (name.isBlank() || phone.isBlank())
            return null;
        User newUser = new User(name, phone, email, address);
        users.put(newUser.getId(), newUser);
        return newUser;
    }

    public User updateUser(String id, String name, String phone, String email, String address) {
        return users.get(id).updateUser(name, phone, email, address);
    }

    public void deleteUser(String id) {
        users.remove(id);
    }

    public void assignBookToUser(String userId, String bookId) {
        User user = this.users.get(userId);
        Book book = this.books.get(bookId);
        if (user != null && book != null && book.getCount() > 0 && user.getCurrentBooks().indexOf(bookId) == -1) {
            book.setCount(book.getCount() - 1);
            user.assignBookToUser(bookId);
        }
    }

    public void revokeBookFromUser(String userId, String bookId) {
        User user = this.users.get(userId);
        Book book = this.books.get(bookId);
        if (user != null) {
            user.revokeBookFromUser(bookId);
        }
        if (book != null) {
            book.setCount(book.getCount() + 1);
        }
    }

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> booksArray = new ArrayList<Book>();
        books.forEach((key, val) -> booksArray.add(val));
        return booksArray;
    }

    public Book getBookById(String id) {
        return books.get(id);
    }

    public Book createBook(String name, String author, int count, ArrayList<String> genre) {
        Book newBook = new Book(name, author, count, genre);
        books.put(newBook.getId(), newBook);
        return newBook;
    }

    public Book updateBook(String id, String name, String author, int count, ArrayList<String> genre) {
        return books.get(id).updateBook(name, author, count, genre);
    }

    public void deleteBook(String id) {
        books.remove(id);
    }
}