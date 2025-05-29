import java.util.*;

public class TwoLargeBags2067B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> mp = new HashMap<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                mp.put(x, mp.getOrDefault(x, 0) + 1); // Count frequency
            }

            boolean flag = false;

            // we convert map to TreeMap for ordered keys
            TreeMap<Integer, Integer> ordered = new TreeMap<>(mp);

            for (Map.Entry<Integer, Integer> entry : ordered.entrySet()) {
                int key = entry.getKey();
                int freq = ordered.getOrDefault(key, 0);

                if (freq >= 2) {
                    int next = ordered.getOrDefault(key + 1, 0);
                    ordered.put(key + 1, next + (freq - 2));
                    ordered.put(key, 2); // Keep at most 2 of current
                }

                if (ordered.get(key) < 2) {
                    flag = true;
                    break;
                }
            }

            System.out.println(flag ? "NO" : "YES");
        }
    }
}
