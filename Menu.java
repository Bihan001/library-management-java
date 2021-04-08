import java.util.Scanner;

public class Menu {
    private UsersUtility usersUtility;
    private BooksUtility booksUtility;

    Menu(UsersUtility usersUtility, BooksUtility booksUtility) {
        this.usersUtility = usersUtility;
        this.booksUtility = booksUtility;
    }

    public void runMainMenu() {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
        sc.close();
    }

    private void mainMenu(Scanner sc) {
        int option;
        System.out.println("1. Books");
        System.out.println("2. Users");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
        option = sc.nextInt();
        boolean shouldExit = false;
        if (option == 1)
            booksMenu(sc);
        else if (option == 2)
            usersMenu(sc);
        else if (option == 3)
            shouldExit = true;
        else
            System.out.println("Wrong option!");
        System.out.println();
        if (shouldExit)
            return;
        mainMenu(sc);
    }

    private void booksMenu(Scanner sc) {
        int option;
        System.out.println("1. Create book");
        System.out.println("2. Read book");
        System.out.println("3. Update book");
        System.out.println("4. Delete book");
        System.out.println("5. Display all books");
        System.out.println("6. Back");
        System.out.print("Select an option: ");
        option = sc.nextInt();
        boolean shouldExit = false;
        switch (option) {
        case 1:
            // Create book
            booksUtility.createBook();
            break;
        case 2:
            // Read book
            booksUtility.getBook();
            break;
        case 3:
            // Update book
            booksUtility.updateBook();
            break;
        case 4:
            // Delete book
            booksUtility.deleteBook();
            break;
        case 5:
            // Display all books
            booksUtility.getAllBooks();
            break;
        case 6:
            shouldExit = true;
            break;
        default:
            // Wrong option
            System.out.println("Wrong option!");
            break;
        }
        System.out.println();
        if (shouldExit)
            return;
        booksMenu(sc);
    }

    private void usersMenu(Scanner sc) {
        int option;
        System.out.println("1. Create user");
        System.out.println("2. Read user");
        System.out.println("3. Update user");
        System.out.println("4. Delete user");
        System.out.println("5. Assign book to user");
        System.out.println("6. Revoke book from user");
        System.out.println("7. Display all users");
        System.out.println("8. Back");
        System.out.print("Select an option: ");
        option = sc.nextInt();
        boolean shouldExit = false;
        switch (option) {
        case 1:
            // Create user
            usersUtility.createUser();
            break;
        case 2:
            // Read user
            usersUtility.getUser();
            break;
        case 3:
            // Update user
            usersUtility.updateUser();
            break;
        case 4:
            // Delete user
            usersUtility.deleteUser();
            break;
        case 5:
            // Assign book to user
            usersUtility.assignBookToUser();
            break;
        case 6:
            // Revoke book from user
            usersUtility.revokeBookFromUser();
            break;
        case 7:
            // Display all users
            usersUtility.getAllUsers();
            break;
        case 8:
            shouldExit = true;
            break;
        default:
            // Wrong option
            System.out.println("Wrong option!");
            break;
        }
        System.out.println();
        if (shouldExit)
            return;
        usersMenu(sc);
    }
}
