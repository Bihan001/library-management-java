import java.util.ArrayList;
import java.util.Arrays;

public class MockData {
    public void generate(Database db) {
        db.createUser("Bihan Chakraborty", "9830844793", "bh.kaito@gmail.com", "Bankra IAC Society");
        db.createUser("Niharika Dutta", "9123456780", "dniharika@gmail.com", "Laketown house");
        db.createUser("Spandita Banerjee", "9134562780", "spandita@gmail.com", "Behala");
        db.createUser("Ankur Saha", "9988776655", "ankursahamoto@gmail.com", "Ultodanga Uproad");

        db.createBook("David Copperfield", "Charles Dickens", 5,
                new ArrayList<String>(Arrays.asList("Novel", "Fiction")));
        db.createBook("Sherlock Holmes", "Arthur Conan Doyle", 3,
                new ArrayList<String>(Arrays.asList("Fiction", "Mystry", "Thriller", "Crime", "Drama", "adventure")));
        db.createBook("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 0,
                new ArrayList<String>(Arrays.asList("Fantasy", "Fiction", "Drama", "Mystry", "Thriller")));

    }

}
