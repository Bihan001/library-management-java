import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {
    private static Connection connection = getConnection();

    public static void createUsersTable() {
        try {
            PreparedStatement createTable = connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS users(id int NOT NULL AUTO_INCREMENT, name varchar(255), phone varchar(255), email varchar(255), address varchar(255), PRIMARY KEY(id))");
            createTable.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Connection getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/libraryproject";
            String username = "root";
            String password = "password";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
