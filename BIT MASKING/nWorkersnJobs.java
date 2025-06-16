import java.util.Arrays;
import java.util.Scanner;

public class nWorkersnJobs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = sc.nextInt();
            }
        }

        int dp[][] = new int[21][(1 << 21)];
        for(int i = 0; i < 21; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(minCost(0, (1 << n) - 1, n, cost, dp));
        sc.close();
    }

    public static int minCost(int i, int mask, int n, int[][] cost, int[][] dp) {
        if(i == n) return 0;

        if(dp[i][mask] != -1) return dp[i][mask];

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) {
            if((mask & (1 << j)) != 0)
                res = Math.min(res, cost[j][i] + minCost(i + 1, mask ^ (1 << j), n, cost, dp));
        }

        return dp[i][mask] = res;
    }
}
