package Common;

public class DataFaker {
    public static long generateToString() {
        return System.currentTimeMillis();
    }

    public static String generateRandomEmail(String email) {
        String[] parts = email.split("@");
        String part1 = parts[0];
        String part2 = parts[1];
        return part1 + generateToString() + "@" + part2;
    }
}
