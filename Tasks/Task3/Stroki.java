import java.util.*;

public class Stroki {
    public static boolean isAnagram(String a, String b) {
        char[] a1 = a.toCharArray();
        char[] b1 = b.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(b1);
        boolean retVal = Arrays.equals(a1, b1); 
        return retVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(",", 2);
        String word1 = parts[0].trim();
        String word2 = parts[1].trim();
        System.out.println(isAnagram(word1, word2));
        sc.close();
    }
}
