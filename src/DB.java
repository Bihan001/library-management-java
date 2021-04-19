import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DB {
    private Connection connection;

    DB() {
        this.connection = getConnection();
    }

    public void createUsersTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS users(id int NOT NULL AUTO_INCREMENT, name varchar(255), phone varchar(255), email varchar(255) UNIQUE, address varchar(255), current_books varchar(255), PRIMARY KEY(id))";
            Utils.execUpdate(this.connection, query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createBooksTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS books(id int NOT NULL AUTO_INCREMENT, name varchar(255), author varchar(255), count int, genres varchar(255), PRIMARY KEY(id))";
            Utils.execUpdate(this.connection, query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        try {
            String query = "SELECT * from users";
            ResultSet res = Utils.execQuery(this.connection, query);
            while (res.next()) {
                User user = new User(res.getString("id"), res.getString("name"), res.getString("phone"),
                        res.getString("email"), res.getString("address"), res.getString("current_books"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
            return users;
        }
    }

    public User readUserByField(String field, String value) {
        try {
            String query = String.format("SELECT * FROM users WHERE %s='%s'", field, value);
            ResultSet res = Utils.execQuery(this.connection, query);
            while (res.next()) {
                User user = new User(res.getString("id"), res.getString("name"), res.getString("phone"),
                        res.getString("email"), res.getString("address"), res.getString("current_books"));
                return user;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public User createUser(String name, String phone, String email, String address) {
        try {
            if (name.isBlank() || phone.isBlank())
                return null;
            String query = String.format(
                    "INSERT INTO users(name, phone, email, address, current_books) VALUES ('%s','%s','%s','%s', '%s');",
                    name, phone, email, address, "");
            PreparedStatement p = this.connection.prepareStatement(query);
            p.executeUpdate();
            return readUserByField("email", email);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public User updateUser(String id, String name, String phone, String email, String address) {
        if (id.isBlank())
            return null;
        String query = String.format("UPDATE users SET %s %s %s %s WHERE id='%s'",
                !name.isBlank() ? "name=" + "'" + name + "'," : "",
                !phone.isBlank() ? "phone=" + "'" + phone + "'," : "",
                !email.isBlank() ? "email=" + "'" + email + "'," : "",
                !address.isBlank() ? "address=" + "'" + address + "'" : "", id);
        Utils.execUpdate(this.connection, query);
        return readUserByField("id", id);
    }

    public void deleteUser(String id) {
        String query = String.format("DELETE FROM users WHERE id='%s'", id);
        Utils.execUpdate(this.connection, query);
    }

    public void assignBookToUser(String userId, String bookId) {
        User user = readUserByField("id", userId);
        Book book = readBookByField("id", bookId);
        if (user == null || book == null)
            return;
        ArrayList<String> currentBooks = Utils.getArrayListFromString(user.getCurrentBooks());
        if (currentBooks.contains(bookId))
            return;
        currentBooks.add(bookId);
        String currentBooksStr = String.join(",", currentBooks);
        String query = String.format("UPDATE users SET current_books='%s' WHERE id='%s'", currentBooksStr, userId);
        Utils.execUpdate(connection, query);
    }

    public void revokeBookFromUser(String userId, String bookId) {
        User user = readUserByField("id", userId);
        Book book = readBookByField("id", bookId);
        if (user == null || book == null)
            return;
        ArrayList<String> currentBooks = Utils.getArrayListFromString(user.getCurrentBooks());
        if (!currentBooks.contains(bookId))
            return;
        currentBooks.remove(bookId);
        String currentBooksStr = String.join(",", currentBooks);
        String query = String.format("UPDATE users SET current_books='%s' WHERE id='%s'", currentBooksStr, userId);
        Utils.execUpdate(connection, query);
    }

    // Books

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        try {
            String query = "SELECT * from books";
            ResultSet res = Utils.execQuery(this.connection, query);
            while (res.next()) {
                ArrayList<String> genres = Utils.getArrayListFromString(res.getString("genres"));
                Book book = new Book(res.getString("id"), res.getString("name"), res.getString("author"),
                        res.getInt("count"), genres);
                books.add(book);
            }
            return books;
        } catch (Exception e) {
            System.out.println(e);
            return books;
        }
    }

    public Book readBookByField(String field, String value) {
        try {
            String query = String.format("SELECT * FROM books WHERE %s='%s'", field, value);
            ResultSet res = Utils.execQuery(this.connection, query);
            while (res.next()) {
                ArrayList<String> genres = Utils.getArrayListFromString(res.getString("genres"));
                Book book = new Book(res.getString("id"), res.getString("name"), res.getString("author"),
                        res.getInt("count"), genres);
                return book;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Book createBook(String name, String author, int count, String genre) {
        try {
            if (name.isBlank() || author.isBlank())
                return null;
            String query = String.format("INSERT INTO books(name, author, count, genres) VALUES ('%s','%s','%s','%s');",
                    name, author, count, genre);
            PreparedStatement p = this.connection.prepareStatement(query);
            p.executeUpdate();
            return readBookByField("name", name);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public Book updateBook(String id, String name, String author, int count, String genre) {
        if (id.isBlank())
            return null;
        String query = String.format("UPDATE books SET %s %s %s %s WHERE id='%s'",
                !name.isBlank() ? "name=" + "'" + name + "'," : "",
                !author.isBlank() ? "author=" + "'" + author + "'," : "",
                count >= 0 ? "count=" + "'" + count + "'," : "", !genre.isBlank() ? "genres=" + "'" + genre + "'" : "",
                id);
        Utils.execUpdate(this.connection, query);
        return readBookByField("id", id);
    }

    public void deleteBook(String id) {
        String query = String.format("DELETE FROM books WHERE id='%s'", id);
        Utils.execUpdate(this.connection, query);
    }

    public Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://remotemysql.com:3306/4ERVN96YDC";
            String username = "4ERVN96YDC";
            String password = "ZNBlGkhQUf";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
