import java.util.function.BiPredicate;

public class BetterString {
    public static String betterString(String s1, String s2, BiPredicate<String, String> p) {
        // If the return is True, then s1 is better -> return it.
        if(p.test(s1, s2)) return s1;
        else return s2;
    }

    public static void main(String[] args) {
        System.out.println("\nThe better string is:\n" + betterString("Better", "Worse", (s1, s2) -> s1.length() > s2.length()));
    }
}
