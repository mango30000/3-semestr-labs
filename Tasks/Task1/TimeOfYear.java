import java.util.Scanner;

public class TimeOfYear {
    public static String season(int month) {
        if (month == 12 || month == 1 || month == 2) return "зима";
        if (month == 3 || month == 4 || month == 5) return "весна";
        if (month == 6 || month == 7 || month == 8) return "лето";
        if (month == 9 || month == 10 || month == 11) return "осень";
        return "Время года";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        System.out.println(season(month));
        sc.close();
    }
}
