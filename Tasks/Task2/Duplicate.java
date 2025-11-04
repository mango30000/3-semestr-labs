import java.util.Scanner;

public class Duplicate {
    public static boolean hasDuplicates(int list[]){
        for (int i = 0; i < list.length; i++ ) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) return true;
            }
        } 
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list = sc.nextLine().trim();

        int[] numbers;

        if (list.isEmpty()) numbers = new int[0];
        else { 
            String[] parts = list.split(",");
            numbers = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                numbers[i] = Integer.parseInt(parts[i].trim());
            }
        }
        System.out.println(hasDuplicates(numbers));
        sc.close();
    }
}

