import java.util.*;
public class WordFrequency {
    public static Map<String, Integer> wordHistogram(String text) {
        Map<String, Integer> frequency = new LinkedHashMap<>();
        
        if (text == null || text.isEmpty()) {
            return frequency;
        }
        
        String cleaned = text.toLowerCase().replaceAll("[^a-zа-яё0-9\\s]", "");
  
        String[] words = cleaned.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        
        return frequency;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        Map<String, Integer> result = wordHistogram(text);
        System.out.print("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());
            if (i < result.size() - 1) {
                System.out.print(", ");
            }
            i++;
        }
        System.out.println("}");
        scanner.close();
    }
}
