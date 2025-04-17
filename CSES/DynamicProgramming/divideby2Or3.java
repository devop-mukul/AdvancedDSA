//Problem Link - https://cses.fi/problemset/task/1633

package DynamicProgramming;

import java.util.Scanner;
import java.util.Arrays;

class DynamicProgramming {
    static int count = 0;

    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        x.close();

        int[] dP = new int[n + 1];
        Arrays.fill(dP, -1);

        System.out.print("Total Combinations : " + Combinations(n, dP));
        System.out.println();
        System.out.print("Function calls : " + count);
    }

    public static int Combinations(int n, int[] dP) {
        count++;

        if (n == 0) return 1;

        if (dP[n] != -1) return dP[n];

        dP[n] = Combinations(n / 2, dP) + Combinations(n / 3, dP);

        return dP[n];
    }
}



