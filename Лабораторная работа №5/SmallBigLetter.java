import java.util.regex.*;

public class SmallBigLetter {
    public static void main(String[] args) {
        String text = "ssfdK lfmP Gkm epvmN";
        try {
            String result = text.replaceAll("([a-z])([A-Z])", "!$1$2!");
            System.out.println("Текст до: " + text);
            System.out.println("Текст после: " + result);
        } catch (PatternSyntaxException e) {
            System.err.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}