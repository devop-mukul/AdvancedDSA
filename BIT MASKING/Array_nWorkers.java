import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array_nWorkers {
    public static void main(String []arg) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        List<Integer> work = new ArrayList<>(java.util.Collections.nCopies(n, 0));

        for(int i = 0; i < n; i++) {
            System.out.println("Add no of days of worker " + (i + 1));
            int d = sc.nextInt();
            int mask = 0;
            System.out.println("dates of work");
            for(int j = 0; j < d; j++) {
                int x = sc.nextInt();
                mask = mask ^ (1 << (x - 1));
            }
            work.set(i, mask);
            // printtoBinary(mask);
            // System.out.println();

            //PAIRING
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++) {
                for(int k = i + 1; k < n; k++) {
                    max = (Math.max(max , findIntersection(work.get(j), work.get(k))));
                }
            }
        }

    }

    public static int findIntersection(int x, int y) {
        int t = x & y;
        int count = 0;
        while(t > 0) {
            count++;
            t = t & (t - 1);
        }
        return count;
    }
    public static void printtoBinary(int n) {
        if(n == 0)
            return;
        
        int t = n % 2;
        printtoBinary(n / 2);
        System.out.print(t);
    }

}
