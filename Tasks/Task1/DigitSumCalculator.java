import java.util.Scanner;

public class DigitSumCalculator{
    public static int digitSum(int number) {
        int sum = 0;
        number = Math.abs(number);
        while (number > 0) {
            sum += number % 10; 
            number /= 10;
        }
        return sum;         
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int sumd = digitSum(number);
        System.out.println(sumd);

        sc.close();
    }
}
