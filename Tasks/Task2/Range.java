import java.util.Scanner;

public class Range {
    public static int sumRange(int a, int b) {
        int sumab = 0;
        for (int i = a; i <= b; i++) {
            sumab += i;
        }
        return sumab;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] parts = line.split(",");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());
        System.out.println(sumRange(a,b));
        sc.close(); 
    }
}