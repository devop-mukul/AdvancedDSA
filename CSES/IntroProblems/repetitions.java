//Problem Link - https://cses.fi/problemset/task/1069

//package CSES;

import java.util.Scanner;

public class repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dnaSequence = scanner.nextLine();
        scanner.close();

        int maxRepetitionLength = 1;
        int currentRepetitionLength = 1;

        for (int i = 1; i < dnaSequence.length(); i++) {
            if (dnaSequence.charAt(i) == dnaSequence.charAt(i - 1)) {
                currentRepetitionLength++;
                maxRepetitionLength = Math.max(maxRepetitionLength, currentRepetitionLength);
            } else {
                currentRepetitionLength = 1;
            }
        }

        System.out.println(maxRepetitionLength);
    }
}

// while(j < n) {
//     j++;
//     while(i < j && str[i] != str[j]) {
//         i++;
//         mx = max(mx, j - i + 1);
//     }
// }