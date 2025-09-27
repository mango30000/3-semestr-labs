import java.util.Scanner;

public class OddEvenNum {
    public static boolean isEven(int number) {
        if (number % 2 == 0)
            return true;
        else return false; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        boolean a = isEven(number);
        System.out.println(a);

        sc.close();
    }
}
