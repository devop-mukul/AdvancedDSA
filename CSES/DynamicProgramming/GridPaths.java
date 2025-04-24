//package DynamicProgramming;

import java.util.Scanner;

public class GridPaths {

    static final int MOD = 1_000_000_007;

    int fxn(int i, int j, char[][] grid, int[][] dp) {
        if (i < 0 || j < 0 || grid[i][j] == '*') {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int left_cell = fxn(i, j - 1, grid, dp) % MOD;
        int up_cell = fxn(i - 1, j, grid, dp) % MOD;

        return dp[i][j] = (left_cell + up_cell) % MOD;
    }

    public int solve(int n, char[][] grid) {
        if (grid[0][0] == '*' || grid[n - 1][n - 1] == '*') {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return fxn(n - 1, n - 1, grid, dp);
    }

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        x.nextLine(); // consume leftover newline

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = x.nextLine();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        x.close();

        GridPaths solver = new GridPaths();
        int result = solver.solve(n, grid);
        System.out.println(result);
    }
}
