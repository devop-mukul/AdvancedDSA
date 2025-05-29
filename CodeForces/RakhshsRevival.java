import java.util.Scanner;

class RakhshsRevival {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, k, i = 0, count = 0, operation = 0;
        n = sc.nextInt();
        m = sc.nextInt();  
        k = sc.nextInt();
        String s = sc.next();

        while(i < n) {
            count = 0;
            operation = 0;
            if(s.charAt(i) == '0') {
                count++;
                if(count == m) {
                    operation++;
                    count = 0;
                    i += k - 1;
                }
            }
            else {
                count = 0;
            }
            i++;    
        }
        
        System.out.println(operation);
        sc.close();
    }
}