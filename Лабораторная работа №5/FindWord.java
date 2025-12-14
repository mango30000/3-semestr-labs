import java.util.regex.*;

public class FindWord {
    public static void main(String[] args) {
        String text = "Apple and banana are fruits.";
        char startLetter = 'a';
        try{
            Pattern pattern = Pattern.compile("\\b" + startLetter + "[a-zA-Z]*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            boolean found = false;
            System.out.println("Найденные слова:");
            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            } 
            if (!found) {
                System.out.println("Слов, начинающихся с " + startLetter + " не найдено.");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}
