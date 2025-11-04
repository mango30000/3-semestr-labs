import java.util.Scanner;

public class PositiveMassiv {
    public static int sumOfPositives(int list[]){
        int sum = 0;
        for (int i : list) {
            if (i > 0) sum += i;
        } 
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine().trim();
        String[] parts = list.split(",");
        int[] numbers = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(sumOfPositives(numbers));
        sc.close();
    }
}
