import java.util.*;

public class Difference {
    public static int differenceMaxMin(int[] numbers) {
        Arrays.sort(numbers);
        int max = numbers[numbers.length - 1];
        int min = numbers[0];
        int dif = max - min;
        return dif;
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
        System.out.println(differenceMaxMin(numbers));
        sc.close();
    }
}
