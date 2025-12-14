import java.util.Scanner;

public class DigitQuantity {
    
    public static int[] digitHistogram(long number) {
        int[] histogram = new int[10];
        number = Math.abs(number);
        if (number == 0) {
            histogram[0] = 1;
            return histogram;
        }
        
        while (number > 0) {
            int digit = (int)(number % 10);
            histogram[digit]++;
            number /= 10;
        }
        
        return histogram;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long number = scanner.nextLong();
        
        int[] result = digitHistogram(number);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
        scanner.close();
    }
}