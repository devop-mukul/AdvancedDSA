//https://leetcode.com/problems/scramble-string/description/


package AdvancedDSA.DynamicProgramming;

public class ScrambleString {
    public static void main(String[] args) {
        String s1 = "eatgr", s2 = "rgeat";
        //           01234  
        int i = 3, n = s1.length();
        System.out.println(s1.substring(0, i));
        System.out.println(s2.substring(n - i, n));
        s1 = "eatgr";
        System.out.println(s1.substring(i, n));
        System.out.println(s2.substring(0, n - i));
    }
}
