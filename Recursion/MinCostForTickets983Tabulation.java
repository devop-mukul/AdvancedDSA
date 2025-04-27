package Recursion;

//TABULATION METHOD
// https://leetcode.com/problems/minimum-cost-for-tickets/description/
import java.util.Arrays;
import java.util.Scanner;

public class MinCostForTickets983Tabulation {
    public static int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1]; 
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0; 

        for (int k = n - 1; k >= 0; k--) {
            
            int day1 = costs[0] + dp[k + 1];

            
            int i = k;
            while (i < n && days[i] < days[k] + 7) i++;
            int day7 = costs[1] + dp[i];

            
            int j = k;
            while (j < n && days[j] < days[k] + 30) j++;
            int day30 = costs[2] + dp[j];

            dp[k] = Math.min(day1, Math.min(day7, day30));
        }

        return dp[0];
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
        for (int i = 0; i < n; i++) {
            costs[i] = r.nextInt();
        }
        r.close();
        System.out.println(mincostTickets(days, costs));
    }
}
