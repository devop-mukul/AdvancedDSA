// //package DynamicProgramming;

// import java.util.Scanner;

// public class RemovingDigitsCSES {
//     public static int removeDigits(int n, int dp[]) {
//         if(dp[n] != -1) return dp[n]; // Check if already computed
//         if(n == 0) return 0; // Base case - no digits left to remove

//         String str = Integer.toString(n); // Convert number to string
//         int min = (int) 1e9; // Initialize min to a large value

//         for(char i : str.toCharArray()) {
//             int x = i - '0'; // Convert character to integer
//             if(x != 0 && n - x >= 0) 
//                 min = Math.min(min, removeDigits(n - x, dp)); 
//         }

//         return dp[n] = min + 1;
//     }
//     public static void main(String[] args) {
//         Scanner x = new Scanner(System.in);
//         int n = x.nextInt(); 
//         int[] dp = new int[n + 1]; 
//         for (int i = 0; i <= n; i++) dp[i] = -1;
//         System.out.println(removeDigits(n, dp)); 

//         x.close();
//     }
// }
package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class RemovingDigitsCSES {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Create BufferedReader for input
        int n = Integer.parseInt(br.readLine()); // Read the number
        int[] dp = new int[n + 1]; // Initialize dp array

        dp[0] = 0; // Base case: 0 steps needed to reduce 0 to 0

        for (int i = 1; i <= n; i++) { // Loop from 1 to n
            dp[i] = (int) 1e9; // Initialize with a large value

            String str = Integer.toString(i); // Convert number to string
            for (char c : str.toCharArray()) { // Loop through each digit
                int digit = c - '0'; // Convert character to integer
                if (digit != 0 && i - digit >= 0) { 
                    dp[i] = Math.min(dp[i], dp[i - digit] + 1); // Update dp[i] by removing the digit
                }
            }
        }

        System.out.println(dp[n]); // Print the minimum number of steps
        br.close(); // Close the BufferedReader
    }
}
