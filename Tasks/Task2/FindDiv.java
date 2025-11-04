import java.util.Scanner;

public class FindDiv {
    public static int countDivisors(int s) {
        int x;
        int countx = 0;
        for (x = 1; x <= s; x++) {
            if (s % x == 0) countx ++;
        }
        return countx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(countDivisors(s));
        sc.close();
    }
}
