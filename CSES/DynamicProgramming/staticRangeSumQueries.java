/*import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class staticRangeSumQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // List<Integer> arr = Arrays.asList(1, 2, 3, 5, 8, 6, 9, 2, 1, 7);
        //           0  1  2  3  4  5  6  7  8  9

        double chunk = Math.sqrt(arr.size());
        List<Integer> newArr = new ArrayList<>((int)(chunk + 1));
        for (int i = 0; i <= chunk; i++) newArr.add(0);

        for(int i = 0; i < arr.size(); i++) {
            int idx = (int)(i / chunk);
            newArr.set(idx, newArr.get(idx) + arr.get(i));
        }
        long[] query = new long[q];
        for(int i = 0; i < q; i++)  {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query[i] = query(arr, newArr, l - 1, r - 1); // Query from index l to r
        }

        //System.out.println(query(arr, newArr, 0, 7));
        for(long ele : query) {
            System.out.println(ele);
        }
    }

    public static long query(List<Integer> arr, List<Integer> newArr, int l, int r) {
        long result = 0;
        int chunk = (int)Math.sqrt(arr.size());
        // left
        while (l % chunk != 0 && l < r && l != 0) {
            result += arr.get(l++);
        }
        // middle
        while (l + chunk <= r) {
            result += newArr.get(l / chunk);
            l += chunk;
        }
        // right part
        while (l <= r) {
            result += arr.get(l++);
        }
        return result;
    }
}*/


//SCANNER INPUT
/*import java.util.Scanner;


public class staticRangeSumQueries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int chunk = (int)Math.sqrt(n);
        int[] newArr = new int[(n + chunk - 1) / chunk];
        for (int i = 0; i < n; i++) {
            newArr[i / chunk] += arr[i];
        }

        long[] query = new long[q];
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            query[i] = query(arr, newArr, l - 1, r - 1); // Query from index l to r
        }

        for (long ele : query) {
            System.out.println(ele);
        }
    }

    public static long query(int[] arr, int[] newArr, int l, int r) {
        long result = 0;
        int chunk = (int)Math.sqrt(arr.length);
        // left
        while (l % chunk != 0 && l <= r && l != 0) {
            result += arr[l++];
        }
        // middle
        while (l + chunk <= r) {
            result += newArr[l / chunk];
            l += chunk;
        }
        // right part
        while (l <= r) {
            result += arr[l++];
        }
        return result;
    }
}
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class staticRangeSumQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nq = br.readLine().split(" ");
        int n = Integer.parseInt(nq[0]);
        int q = Integer.parseInt(nq[1]);

        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int chunk = (int)Math.sqrt(n);
        int numBlocks = (n + chunk - 1) / chunk;
        int[] newArr = new int[numBlocks];
        for (int i = 0; i < n; i++) {
            newArr[i / chunk] += arr[i];
        }

        for (int i = 0; i < q; i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            System.out.println(query(arr, newArr, l - 1, r - 1, chunk));
        }
    }

    public static long query(int[] arr, int[] newArr, int l, int r, int chunk) {
        long result = 0;
        // left
        while (l % chunk != 0 && l <= r) {
            result += arr[l++];
        }
        // middle
        while (l + chunk - 1 <= r) {
            result += newArr[l / chunk];
            l += chunk;
        }
        // right part
        while (l <= r) {
            result += arr[l++];
        }
        return result;
    }
}