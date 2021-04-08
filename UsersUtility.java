import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UsersUtility {
    private Database db;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    UsersUtility(Database db) {
        this.db = db;
    }

    public void createUser() {
        try {
            String name, email, phone, address;
            System.out.println("Create new user:");
            System.out.print("Enter name: ");
            name = br.readLine();
            System.out.print("Enter email: ");
            email = br.readLine();
            System.out.print("Enter phone number: ");
            phone = br.readLine();
            System.out.print("Enter address: ");
            address = br.readLine();
            User newUser = db.createUser(name, phone, email, address);
            System.out.println(newUser.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getUser() {
        try {
            String id;
            System.out.println("Get user details:");
            System.out.print("Enter user id: ");
            id = br.readLine();
            User user = db.getUserById(id);
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateUser() {
        try {
            String id, name, phone, email, address;
            System.out.println("Update user:");
            System.out.print("Enter user id: ");
            id = br.readLine();
            System.out.print("Enter name: ");
            name = br.readLine();
            System.out.print("Enter email: ");
            email = br.readLine();
            System.out.print("Enter phone number: ");
            phone = br.readLine();
            System.out.print("Enter address: ");
            address = br.readLine();
            User user = db.updateUser(id, name, phone, email, address);
            System.out.println(user.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteUser() {
        try {
            String id;
            System.out.println("Delete user:");
            System.out.print("Enter user id: ");
            id = br.readLine();
            db.deleteUser(id);
            System.out.println("Deleted user with id: " + id);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void getAllUsers() {
        try {
            System.out.println("All user details:");
            ArrayList<User> users = db.getAllUsers();
            users.forEach((user) -> System.out.println(user.toString()));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void assignBookToUser() {
        try {
            String userId, bookId;
            System.out.println("Assign book to user:");
            System.out.print("Enter user id: ");
            userId = br.readLine();
            System.out.print("Enter book id: ");
            bookId = br.readLine();
            db.assignBookToUser(userId, bookId);
            System.out.println("Assigned book to user");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void revokeBookFromUser() {
        try {
            String userId, bookId;
            System.out.println("Revoke book from user:");
            System.out.print("Enter user id: ");
            userId = br.readLine();
            System.out.print("Enter book id: ");
            bookId = br.readLine();
            db.revokeBookFromUser(userId, bookId);
            System.out.println("Revoked book from user");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
