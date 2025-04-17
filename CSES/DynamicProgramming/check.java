package DynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class check {
    public static void main(String[] args) {
        // System.out.print("\033[H\033[2J");
        // System.out.flush();
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        x.close();
        System.out.println(fxn(n));

    }
    public static long fxn(int x) {
        long [] dP = new long[x];
        for(int i = 0; i < dP.length; i++) {
            dP[i] = -1;
        }

        int m = 10_00_00_00_07;
        
        if(x == 0) return 1;
        long s = 0;
        if(dP[x] != -1) return dP[x] % m;
        for(int i = 1; i <= 6; i++) {
            if(x - i >= 0) {
                s += fxn(x - i);
            }
        }
        dP[x] = s;
        return dP[x] % m;
    }
}
