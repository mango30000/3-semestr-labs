import java.util.Scanner;

public class SquareCalc {
    public static double rectangleArea(double a, double b) {
        return a * b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        double S = rectangleArea(a, b);
        System.out.println(S);

        sc.close();
    }    
}
