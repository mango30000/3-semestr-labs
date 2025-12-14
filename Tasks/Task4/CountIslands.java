import java.util.Scanner;
public class CountIslands {
    public static int countIslands(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length, islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    islands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return islands;
    }

    private static void dfs(int[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] != 1) return;
        grid[i][j] = 0;
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        s = s.substring(1, s.length() - 1); 
        String[] rowParts = s.split("\\],\\[");
        int rows = rowParts.length;
        int cols = rowParts[0].split(",").length;
        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String row = rowParts[i].replaceAll("[\\[\\]]", "").trim();
            String[] nums = row.split(",");
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(nums[j].trim());
            }
        }
        System.out.println(countIslands(grid));
    }
}
