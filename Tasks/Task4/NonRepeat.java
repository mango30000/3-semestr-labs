import java.util.Scanner;

public class NonRepeat {

    public static String buildResult(String s, int index, int[] freq) {
        if (index == s.length()) {
            return "";
        }
        char ch = s.charAt(index);
        char lower = Character.toLowerCase(ch);
        if (freq[lower] <= 3) {
            return ch + buildResult(s, index + 1, freq);
        } else {
            return buildResult(s, index + 1, freq);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();

        int[] freq = new int[256]; 
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            freq[c]++;
        }

        System.out.println(buildResult(s, 0, freq));
    }
}