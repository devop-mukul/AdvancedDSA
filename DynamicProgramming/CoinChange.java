public class CoinChange {
    public static int coinChange(int[] coins, int index, int amount, int[] dp) {
        if(index == 0) return 1e9;

        if(amount == 0) return 0;
        int include = 1e9;

        if(coins[index - 1] <= amount) {
            include = 1 + coinChange(coins, index, amount - coins[index - 1], dp);
        }
        int exclude = coinChange(coins, index - 1, amount, dp);


        return Math.min(include, exclude);
    }

    public static int memoization(int[] coins, int index, int amount, int[][] dp) {
    
        if(index == 0) return (int)1e9;

        if(amount == 0) return 0;

        if(dp[index][amount] != -1) return dp[index][amount];
        int include = (int)1e9;

        if(coins[index - 1] <= amount) {
            include = 1 + memoization(coins, index, amount - coins[index - 1], dp);
        }
        int exclude = memoization(coins, index - 1, amount, dp);


        return dp[index][amount] = Math.min(include, exclude);
    }
     public static int tabulation(int[] coins, int index, int amount, int[][] dp) {
       int i, j;
        for(i = 1; i <= index; i++) {
            for(j = 1; j <= amount; j++) {
                int include = (int)1e9;
                if(coins[i - 1] <= j) 
                    include = 1 + dp[i][j - coins[i - 1]];
            
                int exclude = dp[i - 1][j];

                dp[i][j] = Math.min(include, exclude);
            }
        }
        return dp[index][amount];
    }
    public static void main(String []arg) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }
        for(int j = 1; j <= amount; j++) {
            dp[0][j] = (int)1e9;
        }
        int result = tabulation(coins, coins.length, amount, dp);
        System.out.println("Minimum coins required: " + (result == (int)1e9 ? -1 : result));
    }
}