import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "C:/Users/panir/java/Lab6/test.txt";
        try{
            Map<String, Integer> words = new HashMap<>();
            String content = Files.readString(Paths.get(filePath));
            String[] word = content.split("[^a-zA-Z]+");
            for (String w : word) {
                if (!w.isEmpty()) {
                    String lower = w.toLowerCase();
                    words.put(lower, words.getOrDefault(lower,0) + 1);
                }
            }
            
            List<Map.Entry<String, Integer>> allwords = new ArrayList<>(words.entrySet());
            Collections.sort(allwords, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, 
                    Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            for (int i = 0; i < 10 && i < allwords.size(); i++) {
                Map.Entry<String, Integer> allw = allwords.get(i);
                System.out.println(allw.getKey() + ":" + allw.getValue());
            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}