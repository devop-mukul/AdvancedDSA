package AdvancedDSA.DynamicProgramming;

import java.util.Scanner;

public class MinNonZeroProductArray {
    public static long fxn(long p) {

        Scanner sc = new Scanner(System.in);
        long m = (long) (1e9 + 7);
        long max = (long)(p << 1) - 1;

        long res = (long) pow(max - 1, (max - 1) / 2);

        res = (res % m) * (max % m);

        sc.close();
        return res;
    
    }

    public static long pow(long a, long b) {    
        long m = (long) 1e9 + 7;
        if (b == 0) {
            return 1;
        }

        long temp = pow(a, b / 2);

        temp = temp % m;

        if(b % 2 == 0) return (temp * temp) % m;

        else return ((temp * temp) % m) * (a % m);
    }
    public static void main(String[] args) {
       System.out.println( fxn(3));
    }
}
