import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class beautifulFunction {

    public static int beautifulFunctionUsingSet(int n) {
        Set<Integer> set = new LinkedHashSet<>();
        if(n % 10 == 0) {
            set.add(n);
            n++;
        }
        while(!set.contains(n)) {
            set.add(n);
            n++;
            if(n % 10 == 0) {
                while(n % 10 == 0)
                    n /= 10;
            }
        }
        return set.size();
    }
    
    public static int beautifulFunctionUsingString(int n) {

        return 0;
    }
        public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(beautifulFunctionUsingSet(n));
        System.out.println(beautifulFunctionUsingString(n));
        sc.close();
    }
}