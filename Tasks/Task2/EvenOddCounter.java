import java.util.Scanner;

public class EvenOddCounter {
    public static int[] countEvenOddDigits(int n) {
        n = Math.abs(n);
        int chet = 0, nechet = 0;
        if (n == 0) return new int[]{1,0};

        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) chet++;
            else nechet++;
            n /= 10;
        }
        return new int[]{chet, nechet};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(countEvenOddDigits(n)[0] + ", " + countEvenOddDigits(n)[1]);
        sc.close();
    }
}
