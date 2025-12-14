import java.util.Scanner;

public class PairDifference {
    public static int pairDifference(int[] arr, int k) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        sc.close();

        int lastComma = line.lastIndexOf(',');
        String arrStr = line.substring(0, lastComma).trim();
        int k = Integer.parseInt(line.substring(lastComma + 1).trim());

        arrStr = arrStr.substring(1, arrStr.length() - 1);
        String[] parts = arrStr.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }

        System.out.println(pairDifference(arr, k));
    }
}