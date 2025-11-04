import java.util.Scanner;

public class ScoretoGrade {
    public static String grade(int num) {
        if (num < 0 || num > 100) return "Invalid";
        if (num >= 90) return "A";
        if (num >= 80) return "B";
        if (num >= 70) return "C";
        if (num >= 60) return "D";
        return "F";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(grade(num));
        sc.close();
    }
}
