//Problem Link - https://cses.fi/problemset/task/1633

package DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

class check {
    static int count = 0;
    public static void main(String[] args) {

        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        x.close();

        System.out.print("Total Combinations : "+ Combinations(n));
        System.out.println();
        System.out.print("Function calls : "+ count);
    }
    public static int Combinations(int n) {
        count++;
        if (n == 0) return 1;
        //if(dP[n] != -1) return dP[n];
        return Combinations(n / 2) + Combinations(n / 3);
    }
}