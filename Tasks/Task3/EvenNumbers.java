import java.util.*;

public class EvenNumbers {
    public static int[] filterEven(int[] num) {
        int count = 0;
        for (int i : num) {
            if (i % 2 == 0) count++;
        }
        int[] en = new int[count];
        int index = 0;
        for (int i : num) {
            if (i % 2 == 0) {
                en[index] = i;
                index++;
            }
        }
        return en;
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

        int[] en = filterEven(numbers);

        System.out.print("[");
        for (int i = 0; i < en.length; i++) {
            System.out.print(en[i]);
            if (i < en.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        sc.close();
    }
}
