import java.util.regex.*;

public class CheckIpAddress {
    public static void main(String[] args) {
        String ip = "192.168.01.1";
        try{
            String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|\\[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
            Pattern pattern = Pattern.compile(regex);
            boolean isValid = pattern.matcher(ip).matches();
            if (isValid) {
                System.out.println("IP-адрес корректен.");
            } else {
                if (!ip.matches("^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$")) {
                    System.out.println("Неверный формат ввода: должно быть 4 числа через точки.");
                } else {
                    System.out.println("Некорректные данные");
                }
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}
