import java.util.Arrays;
import java.util.Scanner;

public class palindromePartitioningGFG {
    public static void main(String[] arg) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++) {
            //for(int j : dp[i][j])
               Arrays.fill(dp[i], -1);
        }
            
        System.out.println(helperTabulation(s, 0, n - 1, dp));
    }

    static int helperTabulation(String s, int i, int j, int[][] dp) {
        if(i == j) return 0;
        
        if(isPalindrome(s, i, j) == 1) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int result = (int)1e9;
        
        for(int k = i; k < j; k++) {
            if(isPalindrome(s, i, k) == 1){
                result = Math.min(result, 1 + helperTabulation(s, i, k, dp) + helperTabulation(s, k + 1, j, dp));
            }
        }
        
        return dp[i][j] = result;
    }

    public static int isPalindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return 0;
            i++;
            j--;
        }
        return 1;
    }
    
    public static int helper(String s, int i, int j) {
        if(i == j) return 0;
        
        if(isPalindrome(s, i, j) == 1) return 0;
        
        int result = (int)1e9;
        
        for(int k = i; k < j; k++) {
            result = Math.min(result, 1 + helper(s, i, k) + helper(s, k + 1, j));
        }
        
        return result;
    }
}