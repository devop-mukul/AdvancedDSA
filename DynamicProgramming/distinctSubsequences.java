import java.util.Arrays;

public class distinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        int result = numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result);
    }
 public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 0; i <= s.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return (lcsMemo(s, t, s.length(), t.length(), dp));
}
public static int lcsMemo(String s1, String s2, int n, int m, int[][] dp) {
        if (m == 0) return 1; //that is if t is empty return "" empty 
        if (n == 0) return 0;

        if(dp[n][m] != -1)
            return dp[n][m];

        if(s1.charAt(n - 1) == s2.charAt(m - 1))
            dp[n][m] =  lcsMemo(s1, s2, n - 1, m, dp) + lcsMemo(s1, s2, n - 1, m - 1, dp);
        else
            dp[n][m] = lcsMemo(s1, s2, n - 1, m, dp);

        return dp[n][m];
    }
}
