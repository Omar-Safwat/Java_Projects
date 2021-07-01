import java.util.function.Predicate;
import java.util.stream.Stream;

public class StringIsLetters {
     
    public static String matchString(String s) {
        if(s != null && !s.isEmpty()) {
            return ( 
                "\n \"" + s + "\" returns:\n" +
                s.chars()
                .allMatch(Character::isLetter));
        }
        else return ("\n" + s + " returns:\n" + "false");
    }
    public static void main(String[] args) {
        String str = "random letters";
        String str2 = "random letters plus number 2";
        String strEmpty = "";
        String strNull = null;

        System.out.println(matchString(str));
        System.out.println(matchString(str2));
        System.out.println(matchString(strEmpty));
        System.out.println(matchString(strNull));        
    } 
}
