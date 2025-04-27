package Recursion;

public class MinDistance72Tabulation {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        
        // Create a DP table where dp[i][j] will hold the minimum number of operations to convert word1[0...i] to word2[0...j]
        int[][] dp = new int[n + 1][m + 1];

        // Initialize the base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;  // If word2 is empty, we need i operations (deletes)
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;  // If word1 is empty, we need j operations (inserts)
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // No operation is needed if the characters are the same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // Take the minimum of insert, delete, or replace
                    dp[i][j] = 1 + Math.min(
                        Math.min(dp[i - 1][j],   // Delete
                                 dp[i][j - 1]),  // Insert
                                 dp[i - 1][j - 1]  // Replace
                    );
                }
            }
        }

        // The answer is in dp[n][m], which represents the minimum operations for word1[0...n] to word2[0...m]
        return dp[n][m];
    }

    // Main function to test the solution
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test with example inputs
        String word1 = "horse";
        String word2 = "ros";

        // Calculate the result and print it
        int result = solution.minDistance(word1, word2);
        System.out.println("Minimum operations needed: " + result);  // Expected output: 3
    }
}