import java.util.Scanner;

public class Reverse {
    public static String reverseWords(String input) {
        String[] first = input.split("\\s+");
        StringBuilder second = new StringBuilder();
        for (int i = first.length - 1; i >= 0; i--) {
            second.append(first[i]);
            if (i > 0) {
                second.append(" ");
            }
        }
        return second.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
        sc.close();
    }
}
