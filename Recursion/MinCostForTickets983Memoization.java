//MEMOIZATION TECHNIQUE
// Time Complexity: O(n)
// Space Complexity: O(n) for dp array
package Recursion;

import java.util.Arrays;
import java.util.Scanner;

class MinCostForTickets983Memoization {
    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length]; 
        Arrays.fill(dp, -1); 
        return helper(days, costs, 0, 0, dp);
    }

    public static int helper(int[] days, int[] cost, int i, int d, int[] dp) {
        while (i < days.length && days[i] <= d)
            i++;
        
        if (i >= days.length) return 0;

        if (dp[i] != -1) return dp[i];

        int d1 = cost[0] + helper(days, cost, i + 1, days[i] + 1 - 1, dp);
        int d7 = cost[1] + helper(days, cost, i + 1, days[i] + 7 - 1, dp);
        int d30 = cost[2] + helper(days, cost, i + 1, days[i] + 30 - 1, dp);

        
        return dp[i] = Math.min(d1, Math.min(d7, d30));
    }

    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int[] days = new int[n];
        System.out.println("Enter days: ");
        for (int i = 0; i < n; i++) {
            days[i] = r.nextInt();
        }

        int m = r.nextInt();
        int [] costs = new int[m];
        System.out.println("Enter cost: ");
        for (int i = 0; i < m; i++) {
            costs[i] = r.nextInt();
        }
        System.out.println(mincostTickets(days, costs));
        r.close();
    }
}
