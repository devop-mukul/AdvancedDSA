import java.util.*;

public class MissingCoinSum {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        int n = x.nextInt();
        long[] coins = new long[n];
        for (int i = 0; i < n; i++) 
            coins[i] = x.nextLong();
        
        x.close();

        Arrays.sort(coins);

        long smallestUnreachable = 1;
        for (int i = 0; i < n; i++) {
            if (coins[i] > smallestUnreachable) {
                break;
            }
            smallestUnreachable += coins[i];
            System.out.println(smallestUnreachable);
        }

        System.out.println(smallestUnreachable);
    }
}
