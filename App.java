
/**
 * App
 */
public class App {
    public static void main(String[] args) {
        // Initialising the database
        Database db = new Database();

        // Generating mock data for testing, not required in production.
        MockData md = new MockData();
        md.generate(db);

        // Initialising utility classes for accessing all the utility functions.
        UsersUtility usersUtility = new UsersUtility(db);
        BooksUtility booksUtility = new BooksUtility(db);

        // Main menu
        Menu menu = new Menu(usersUtility, booksUtility);
        menu.runMainMenu();
    }
}