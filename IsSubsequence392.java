import java.util.Scanner;

public class IsSubsequence392 {
    public static void main(String[] args) {
        String s, t;
        Scanner x = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        s = x.nextLine();
        System.out.println("Enter the second string: ");
        t = x.nextLine();
        System.out.println("Is the first string a subsequence of the second string? " + isSubsequence(s, t));

    }
    public static boolean isSubsequence(String s, String t) {
        int sLength = 0, tLength = 0;

        while (sLength < s.length() && tLength < t.length()) {
            if (s.charAt(sLength) == t.charAt(tLength)) {
                sLength++;
            }
            tLength++;
        }

        return sLength == s.length();
    }
}
