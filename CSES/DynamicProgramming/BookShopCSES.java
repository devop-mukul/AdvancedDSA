package DynamicProgramming;

import java.util.Scanner;

public class BookShopCSES{
    public static int fxn(int price[], int pages[], int n, int x, int dp[][]) {
        int include = 0, exclude = 0; // Initialize include and exclude variables
        if (n == 0 || x == 0) return 0; // Base case: no books or no budget

        if (dp[n][x] != -1) return dp[n][x]; // Check if already computed

        if (x >= price[n - 1]) { // If the book can be included
            // Option to include the book
            include = pages[n - 1] + fxn(price, pages, n - 1, x - price[n - 1], dp);
            // Option to exclude the book
            exclude = fxn(price, pages, n - 1, x, dp);
            
        }
        return dp[n][x] = Math.max(include, exclude); // Store and return the maximum of both options
}
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Number of books
        int x = sc.nextInt(); // Maximum total price

        int[] price = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt(); // Reading prices
        }

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt(); // Reading pages
        }
        int dp[][] = new int[n + 1][x + 1]; // DP table for memoization
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                dp[i][j] = -1; // Initialize DP table with -1
            }
        }

        System.out.println(fxn(price, pages, n, x, dp)); // Call the function to get the maximum pages
        sc.close(); // Close the scanner
    }
}