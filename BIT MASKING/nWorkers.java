import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class nWorkers {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> workers = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            System.out.println("no of days of "+ (i + 1) + " worker");
            int m = sc.nextInt();
            List<Integer> work = new ArrayList<>();
            System.out.println("Work of " + (i + 1) + " worker");
            for(int j = 0; j < m; j++) {
                work.add(sc.nextInt());
            }
            workers.add(work);
        }
        System.out.println(workers);

       
        sc.close();      
    }

}
