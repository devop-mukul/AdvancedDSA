import java.util.Arrays;
import java.util.Scanner;

public class FactoryMachines {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int nArray;
        int tProducts;
    
        nArray = x.nextInt();
        tProducts = x.nextInt();
        int arr[] = new int[nArray];

        for(int i = 0; i < nArray; i++)
            arr[i] = x.nextInt();
        x.close();

        int maxArray = Arrays.stream(arr).max().getAsInt();
        long l = 0, h = maxArray * tProducts;
        long res = Long.MAX_VALUE;
        
        while(l <= h) {
            long m = l + (h - l) / 2;
            if(possible(m, arr, tProducts, nArray)) {
                res = m;
                h = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        System.out.println(res);
    }

    static boolean possible(long m, int arr[], int tProducts, int nArray) {
        long temp = 0;
        for(int i = 0; i < nArray; i++) {
            temp += m / arr[i];
            if(temp >= tProducts)
                return true;
        }
        return false;
    }
}