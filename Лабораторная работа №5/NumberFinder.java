import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "2395dkg klmgkfmd kldmgk 44343 34 3.2";
        try{
            Pattern pattern = Pattern.compile("\\d+\\.?\\d+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
        } catch(PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}