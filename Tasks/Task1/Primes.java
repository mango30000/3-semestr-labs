import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int n) {
        double s = Math.sqrt(n);
        for(int x = 2; x <= s; x++) {
            if ((n % x) == 0) return false; 
        } 
        return true; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (isPrime(n)) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
        sc.close();
    }  
}
