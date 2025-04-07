//https://cses.fi/problemset/task/1083

package CSES;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String arg[]) {
        Scanner x = new Scanner(System.in);
        long n1 = x.nextLong();
        int n = (int) n1;
        int ar[] = new int[n - 1];
        long sum = 0L;
        for(int i = 0; i < n - 1; i++) {
            ar[i] =  x.nextInt();
            sum += ar[i];
        }
        
        long expectedSum = n * (n + 1) / 2;
        System.out.println(expectedSum - sum);
    }
}
