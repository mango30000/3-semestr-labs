import java.util.Scanner;

public class Palindrome {
    public static String reverseString(String s){
        String d = "";
        int length = s.length();
        for (int i = length - 1; i >= 0; i--) {
            d += s.charAt(i);
        }
        return d;
    }
    public static boolean isPalindrome(String s) {
        String d = reverseString(s);
        return s.equals(d);
    }   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (isPalindrome(s)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        sc.close();
    }
}
