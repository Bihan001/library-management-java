import java.util.ArrayList;

public class Book {
    private String id;
    private String name;
    private String author;
    private int count;
    private ArrayList<String> genre;

    Book(String id, String name, String author, int count, ArrayList<String> genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.count = count;
    }

    public String getId() {
        return this.id;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book updateBook(String name, String author, int count, ArrayList<String> genre) {
        if (!name.isBlank())
            this.name = name;
        if (!author.isBlank())
            this.author = author;
        if (!genre.isEmpty())
            this.genre = genre;
        if (this.count >= 0)
            this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return this.id + ", " + this.name + ", " + this.author + ", " + this.count + ", " + this.genre;
    }

}
