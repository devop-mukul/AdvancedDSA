package SortingSearching;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SumofTwoValues {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int targetSum = x.nextInt();
        int ar[] = new int[n];
        for(int i = 0; i < n; i++) {
            ar[i] = x.nextInt();
        }
        x.close();
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = targetSum - ar[i];
            if (map.containsKey(complement)) {
            System.out.println((map.get(complement) + 1) + " " + (i + 1));
            return;
            }
            map.put(ar[i], i);
        }
        System.out.println("IMPOSSIBLE");
    }
}
