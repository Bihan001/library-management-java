/**
 * App
 */
public class App {
    public static void main(String[] args) {
        // Initialising the database
        DB db = new DB();

        // String test = String.format("test goes here %s more text", "Testing");
        db.createUsersTable();
        db.createBooksTable();

        // Generating mock data for testing, not required in production.
        // MockData md = new MockData();
        // md.generate(db);

        // Initialising utility classes for accessing all the utility functions.
        UsersUtility usersUtility = new UsersUtility(db);
        BooksUtility booksUtility = new BooksUtility(db);

        // Main menu
        Menu menu = new Menu(usersUtility, booksUtility);
        menu.runMainMenu();
    }
}