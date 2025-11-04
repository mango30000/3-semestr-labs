import java.util.Scanner;

public class RotateMassiv {
    public static int[] rotateRight(int[] list, int k){
        int length = list.length;
        if (length == 0) return list;
        k = k % length;
        if (k == 0) return list;

        int[] rotlist = new int[length];
        for (int i = 0; i < length; i++) {
            int newIndex = (i + k) % length;
            rotlist[newIndex] = list[i];
        } 
        return rotlist;
    }

    public static void printArray(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i]);
            if (i != list.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String list = sc.nextLine().trim();

    int bracket = list.indexOf(']');
    String listPart = list.substring(0, bracket + 1);
    String kPart = list.substring(bracket + 2).trim();

    listPart = listPart.substring(1, listPart.length() - 1).trim(); // между []
    int[] numbers;
    if (listPart.isEmpty()) numbers = new int[0];
    else {
        String[] stringNumbers = listPart.split(",");
        numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++)
            numbers[i] = Integer.parseInt(stringNumbers[i].trim());
    }

    int k = Integer.parseInt(kPart);

    printArray(rotateRight(numbers, k));
    sc.close();
    }
}
