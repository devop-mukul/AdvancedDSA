package LeetCode;

import java.util.Scanner;

public class FlipStringToMonotoneIncreasing926 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        String s;
        System.out.println("Enter the string: ");
        s = x.nextLine();
        x.close();
        int[][] dp = new int[s.length() + 1][2]; // 📝 DP table to store results for both 0 and 1 previous values
        // Initialize the dp array with -1, indicating not yet calculated 📝
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(minFlipsMonoIncr(s, 0, 0, dp)); // 📝 Starting with 0 as previous value and first character
    }

    public static int minFlipsMonoIncr(String s, int prev_val, int curr_i, int[][] dp) {
        // Base case: if we've processed the entire string
        if (curr_i >= s.length()) return 0;

        // If this state has already been computed, return the stored result
        if (dp[curr_i][prev_val] != -1) return dp[curr_i][prev_val];

        // Initialize flip and dflip to a large number
        int flip = (int) 1e9, dflip = (int) 1e9;

        // Case when the previous value is 0
        if (prev_val == 0) {
            if (s.charAt(curr_i) == '1') {
                // If the current character is 1, we have to flip it to 0 (flip = 1)
                flip = 1 + minFlipsMonoIncr(s, 0, curr_i + 1, dp);
                // Or we can keep it as 1, changing the previous state to 1 (dflip = 0)
                dflip = 0 + minFlipsMonoIncr(s, 1, curr_i + 1, dp);
            } else {
                // If the current character is 0, we can either flip it to 1 (flip = 1)
                flip = 1 + minFlipsMonoIncr(s, 1, curr_i + 1, dp);
                // Or leave it as 0 (dflip = 0)
                dflip = 0 + minFlipsMonoIncr(s, 0, curr_i + 1, dp);
            }
        }
        // Case when the previous value is 1
        else if (prev_val == 1) { // 📝 Corrected 'prev_val == '1'' to 'prev_val == 1'
            if (s.charAt(curr_i) == '1') {
                // If the current character is 1, we can leave it as 1 (dflip = 0)
                dflip = 0 + minFlipsMonoIncr(s, 1, curr_i + 1, dp);
            } else {
                // If the current character is 0, we must flip it to 1 (flip = 1)
                flip = 1 + minFlipsMonoIncr(s, 1, curr_i + 1, dp);
            }
        }

        // Return the minimum of the two choices (flip or dflip)
        return dp[curr_i][prev_val] = Math.min(flip, dflip); // 📝 Corrected DP state indexing
    }
}
