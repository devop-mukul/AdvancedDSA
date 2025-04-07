package AdvancedDSA.BinarySearch;
import java.util.*;

public class BinarySearch {
    public static void main(String arg[]) {
        int ar[] = {8, 6, -5, -10, -11, -15, -20};
        
        int l = ar.length - 1;
        int f = 0, mid;
        
        Scanner x = new Scanner(System.in);
        System.out.print("Enter number: ");
        int find = x.nextInt();

        boolean found = false;

        while (f <= l) { 
            mid = (f + l) / 2;
            
            if (ar[mid] == find) {
                System.out.println("Element found at index: " + mid);
                found = true;
                break;
            } 
            
            else if (ar[mid] > find) { 
                f = mid + 1; 
            } 
            
            else { 
                l = mid - 1; 
            }
        }

        if (!found) {
            System.out.println("Element not found.");
        }
    }
}
