import java.util.ArrayList;

public class Book {
    private String id;
    private String name;
    private String author;
    private int count;
    private ArrayList<String> genre;

    Book(String name, String author, ArrayList<String> genre) {
        this.id = UID.generateBookUID();
        this.name = name;
        this.author = author;
        this.genre = genre;
    }

    public String getId() {
        return this.id;
    }

    public Book updateBook(String name, String author, ArrayList<String> genre) {
        if (!name.isBlank())
            this.name = name;
        if (!author.isBlank())
            this.author = author;
        if (!genre.isEmpty())
            this.genre = genre;
        return this;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.author + ", " + this.genre;
    }

}
