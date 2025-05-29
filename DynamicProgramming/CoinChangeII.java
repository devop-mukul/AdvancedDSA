public class CoinChangeII {
    public static int coinChange(int[] coins, int index, int amount, int [][] dp) {


        return 0;
    }
    public static void main(String[] arg) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = 0;
        int dp[][] = new int[coins.length + 1][amount + 1];
        result = coinChange(coins, coins.length, amount, dp);
        System.out.println("Coin Combinations:" + (result == (int)1e9 ? -1 : result));
    }
}