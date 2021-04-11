public class UID {
    private static int bookUID = 1;
    private static int userUID = 1;

    public static String generateBookUID() {
        return "abc" + bookUID++;
    }

    public static String generateUserUID() {
        return "def" + userUID++;
    }
}
