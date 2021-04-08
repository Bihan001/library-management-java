import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private ArrayList<String> currentBooks;

    User(String name, String phone, String email, String address) {
        this.id = UID.generateUserUID();
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.currentBooks = new ArrayList<String>();
    }

    public String getId() {
        return this.id;
    }

    public User updateUser(String name, String phone, String email, String address) {
        if (!name.isBlank())
            this.name = name;
        if (!phone.isBlank())
            this.phone = phone;
        if (!email.isBlank())
            this.email = email;
        if (!address.isBlank())
            this.address = address;
        return this;
    }

    public void assignBookToUser(String bookId) {
        if (this.currentBooks.indexOf(bookId) == -1)
            this.currentBooks.add(bookId);
    }

    public void revokeBookFromUser(String bookId) {
        this.currentBooks.remove(bookId);
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.email + ", " + this.phone + ", " + this.address + ", "
                + this.currentBooks;
    }

}
