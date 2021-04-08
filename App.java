
/**
 * App
 */
public class App {
    public static void main(String[] args) {
        Database db = new Database();
        UsersUtility usersUtility = new UsersUtility(db);
        BooksUtility booksUtility = new BooksUtility(db);
        Menu menu = new Menu(usersUtility, booksUtility);
        menu.runMainMenu();
    }

}