import java.util.Scanner;

public class MinAdult {
    public static String checkAge(int age) {
        if (age >= 18) return "совершеннолетний";
        if (age < 18) return "несовершеннолетний";
        return "возраст";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        System.out.println(checkAge(age));

        sc.close();
    }
}
