import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExpensiveNumber2093B2 {
static Scanner sc = new Scanner(System.in);    
    public static int funx() {
        
        String s = sc.next();
        int n = s.length();
        int res = n - 1;

        int last_i = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                last_i = i;
                break;
            }
        }

        for (int i = 0; i < last_i; i++) {
            if (s.charAt(i) == '0')
                res--;
        }

        return res;
    }

    public static void main(String[] args) {
        int t = sc.nextInt(); 
        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            arr.add(funx()); 
        }

        for (int result : arr) {
            System.out.println(result);
        }
    }
}
