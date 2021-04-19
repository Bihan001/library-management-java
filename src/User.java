public class User {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String currentBooks;

    User(String id, String name, String phone, String email, String address, String currentBooks) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.currentBooks = currentBooks;
    }

    public String getId() {
        return this.id;
    }

    public String getCurrentBooks() {
        return this.currentBooks;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.email + ", " + this.phone + ", " + this.address + ", "
                + this.currentBooks;
    }

}
