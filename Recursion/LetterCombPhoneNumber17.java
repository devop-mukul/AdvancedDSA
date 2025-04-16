package Recursion;
import java.util.*;

public class LetterCombPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        String ar[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result; // Edge case

        List<Character> temp = new ArrayList<>(); // Using List<Character> instead of StringBuilder
        fxn(result, temp, digits, 0, ar);
        return result;
    }

    private void fxn(List<String> result, List<Character> temp, String digits, int i, String[] ar) {
        if (i == digits.length()) {
            StringBuilder str = new StringBuilder();
            for (char c : temp) str.append(c); // Convert List<Character> to String
            result.add(str.toString());
            return;
        }

        int index = digits.charAt(i) - '0';
        String str = ar[index]; // Get corresponding letters (e.g., "abc" for '2')

        for (int j = 0; j < str.length(); j++) {
            temp.add(str.charAt(j)); // Choose
            fxn(result, temp, digits, i + 1, ar); // Explore next digit
            temp.remove(temp.size() - 1); // Backtrack
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        LetterCombPhoneNumber17 solution = new LetterCombPhoneNumber17();
        
        // Test cases
        String digits = "23"; // Change this input to test different cases
        List<String> combinations = solution.letterCombinations(digits);

        // Print result
        System.out.println("Letter Combinations for \"" + digits + "\": " + combinations);
    }
}
