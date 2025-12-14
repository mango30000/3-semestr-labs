import java.util.regex.*;

public class CheckPassword {
    public static void main(String[] args) {
        String password = "32r34nnKK";
        try{
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,16}");
            boolean isValid = pattern.matcher(password).matches();
            if (isValid) {
                System.out.println("Пароль корректен.");
            } else {
                System.out.println("Пароль не корректен.");
                if (password.length() < 8 || password.length() > 16) {
                    System.out.println("Неверная длина (должно быть 8-16 символов)");
                }
                if (!password.matches("[a-zA-Z\\d]+")) {
                    System.out.println("Содержит запрещённые символы");
                }
                if (!password.matches(".*[A-Z].*")) {
                    System.out.println("Нет заглавной буквы");
                }
                if (!password.matches(".*\\d.*")) {
                    System.out.println("Нет цифры");
                }
            }

        } catch(PatternSyntaxException e) {
            System.out.println("Ошибка в регулярном выражении: " + e.getMessage());
        }
    }
}
