public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + " является палиндромом");
            }
            else {
                System.out.println(s + " не является палиндромом");
            }
        }
    }

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
}
