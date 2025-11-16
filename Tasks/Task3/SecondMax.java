import java.util.*;

public class SecondMax {
    public static int secondLargest(int[] numbers) {
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];
        int secondMax = -1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            if (numbers[i] < max) {
                secondMax = numbers[i];
                break;
            }
        }
        return secondMax;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        input = input.replace("[", "").replace("]", "");
        String[] parts = input.split(",");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i].trim());
        }
        System.out.println(secondLargest(numbers));
        System.out.println(numbers[numbers.length - 1]);
        sc.close();
    }
}
