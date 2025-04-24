package AdvancedDSA.LeetCode;

    import java.util.Arrays;
import java.util.Scanner;

public class LongestIncSubsequence300 {

    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1); // Initialize dp array with -1 for memoization
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, findLIS(nums, i, dp));
        }
        return maxLength;
    }

    private static int findLIS(int[] nums, int currentIndex, int[] dp) {
        if (dp[currentIndex] != -1) {
            return dp[currentIndex]; // Return memoized result
        }

        int maxLengthEndingHere = 1; // Minimum length is 1 (the element itself)
        for (int i = 0; i < currentIndex; i++) {
            if (nums[i] < nums[currentIndex]) {
                maxLengthEndingHere = Math.max(maxLengthEndingHere, 1 + findLIS(nums, i, dp));
            }
        }

        dp[currentIndex] = maxLengthEndingHere; // Store the result
        return maxLengthEndingHere;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the array (space-separated):");

        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        scanner.close();
        int result = longestIncreasingSubsequence(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + result);
    }
}
