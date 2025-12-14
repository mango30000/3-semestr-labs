import java.util.Scanner;

public class RomanConverter {
    
    public static String convertToRome(int number) {
        if (number <= 0 || number > 1502) {
            return "";
        }
        
        String[] thousands = {"", "M"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousand = number / 1000;
        int hundred = (number % 1000) / 100;
        int ten = (number % 100) / 10;
        int unit = number % 10;
    
        return thousands[thousand] + hundreds[hundred] + tens[ten] + units[unit];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
  
        String roman = convertToRome(number);
   
        System.out.println(roman);
        scanner.close();
    }
}