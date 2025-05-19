package Mathematics;

public class CountingDivisors {
    public static void main(String[] args) {
        long n = 258746;
        System.out.println(countDivisors(n));
    }

    public static long countDivisors(long n) {
        long count = 0;
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                count += 2; // i and n/i are both divisors
                if (i * i == n) {
                    count--; // If i is the square root of n, we counted it twice
                }
            }
        }
        return count;
    }
}
