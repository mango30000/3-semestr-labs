import java.util.*;

public class Triangle {
    public static boolean isTriangle(int a, int b, int c) {
        return (a + b > c && a + c > b && b + c > a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(",");
        int a = Integer.parseInt(parts[0].trim());
        int b = Integer.parseInt(parts[1].trim());
        int c = Integer.parseInt(parts[2].trim());
        System.out.println(isTriangle(a, b, c));
        sc.close();
    }
}
