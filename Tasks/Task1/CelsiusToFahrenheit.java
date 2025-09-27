import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static int toFahrenheit(int celsius) {
        return celsius * 9 / 5 + 32;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int celsius = sc.nextInt();

        int fahrenheit = toFahrenheit(celsius);
        System.out.println(fahrenheit);

        sc.close();
    }
}


