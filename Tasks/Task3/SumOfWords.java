import java.util.*;

public class SumOfWords {
    public static int countWords(String words){
        String[] a = words.strip().split("\\s+");
        return a.length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();
        System.out.println(countWords(words));
        sc.close();
    }
}
