import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Utils {
    public static void execUpdate(Connection conn, String query) {
        try {
            PreparedStatement q = conn.prepareStatement(query);
            q.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static ResultSet execQuery(Connection conn, String query) {
        try {
            PreparedStatement q = conn.prepareStatement(query);
            ResultSet res = q.executeQuery();
            return res;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static ArrayList<String> getArrayListFromString(String s) {
        ArrayList<String> arr = new ArrayList<String>();
        for (String g : s.split(",")) {
            arr.add(g.trim());
        }
        return arr;
    }
}
