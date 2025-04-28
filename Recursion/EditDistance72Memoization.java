package Recursion;

import java.util.Arrays;
import java.util.Scanner;

class EditDistance72Memoization {

    static int[][] dp; // Memoization table

    public int fxn(String s1, int n, String s2, int m) {
        if (n == 0 && m == 0) return 0;
        if (n > 0 && m == 0) return n;
        if (m > 0 && n == 0) return m;

        if (dp[n][m] != -1) return dp[n][m]; // Already solved

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = fxn(s1, n - 1, s2, m - 1); // No operation needed
        } else {
            dp[n][m] = 1 + Math.min(
                Math.min(fxn(s1, n, s2, m - 1),  // insert
                         fxn(s1, n - 1, s2, m)), // delete
                         fxn(s1, n - 1, s2, m - 1) // replace
            );
        }

        return dp[n][m];
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        dp = new int[n + 1][m + 1];

        // Initialize dp array with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return fxn(word1, n, word2, m);
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        EditDistance72Memoization solution = new EditDistance72Memoization();
        String word1 = x.nextLine(); // Read first word from input
        String word2 = x.nextLine(); // Read second word from input 

        // Calculate the result and print it
        int result = solution.minDistance(word1, word2);
        System.out.println("Minimum operations needed: " + result);  // Expected output: 3

        x.close();
    }
}
