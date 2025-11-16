import java.util.Scanner;

public class Sum {
    public static int sumOfDigits(int n) {
        n = Math.abs(n);
        int sumd = 0;
        while (n > 0) {
            sumd += n % 10;
            n /= 10;
        }
        return sumd;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sumOfDigits(n));
        sc.close();
    }
}
