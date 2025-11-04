import java.util.Scanner;

public class SumDiag {
    public static int diagonalSum(int[][] matrix) {
        int n = matrix.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int[][] parseMatrix(String input) {
        input = input.trim();
        input = input.substring(2, input.length() - 2);

        String[] rows = input.split("\\],\\[");

        int n = rows.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] nums = rows[i].split(",");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(nums[j].trim());
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String m = sc.nextLine();

        int[][] matrix = parseMatrix(m);
        System.out.println(diagonalSum(matrix));
        sc.close();
    }
}

