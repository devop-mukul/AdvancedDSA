package Mathematics;

public class CommonDivisors {
    public static void main(String[] args) {
        // Example usage
        // int a = 12;
        // int b = 18;
        // System.out.println(gcd(a, b));

        int n = 5;
        int[] arr = {3, 14, 15, 7, 9};
        int max = Integer.MIN_VALUE;

        // Find the maximum GCD of all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(gcd(arr[i], arr[j]), max);
            }
        }

        // Find the maximum GCD of adjacent pairs
        for (int i = 0; i < arr.length; i += 2) {
            if (i + 1 < arr.length) {
                int gcd = gcd(arr[i], arr[i + 1]);
                max = Math.max(gcd, max);
            }
        }

        System.out.println(max);
    }

    public static int gcd(int a, int b) {
        if (b % a == 0) return a;
        return gcd(b % a, a);
    }
}