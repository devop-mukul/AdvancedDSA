// Problem Link - https://cses.fi/problemset/result/12561525/


import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);   
        long n = x.nextLong();
        while(n != 1) {
            System.out.print(n + " ");
            if((n & 1) == 0) {
                n /= 2;
            }
            else {
                n = 3 * n + 1;
            }
        }
        System.out.println(n);
    }
}
