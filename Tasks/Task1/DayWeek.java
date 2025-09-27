import java.util.Scanner;

public class DayWeek {
    public static String daysToWeeks(int days) {
        int weeks = days / 7; 
        int remaindays = days % 7;
        return weeks + " " + Weekend(weeks) + " и " + remaindays + " " + Daysend(remaindays) ;
    }
    public static String Weekend(int weeks) {
        if (weeks == 0 || weeks > 4) return "недель";
        if (weeks == 1) return "неделя";
        if (weeks > 1 && weeks < 5) return "недели";
        return "недель"; 
    }
    public static String Daysend(int remaindays) {
        if (remaindays == 0 || remaindays > 4) return "дней";
        if (remaindays == 1) return "день";
        if (remaindays > 1 && remaindays < 5) return "дня";
        return "дней"; 
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        System.out.println(daysToWeeks(days));
        sc.close();
    }
}
