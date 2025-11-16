import java.util.Scanner;

public class Vowels {
    public static int countVowels(String word) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(countVowels(word));
        sc.close(); 
    }
}
