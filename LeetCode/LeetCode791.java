package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode791 {
    
    public static void main(String[] args) {

        System.out.println(customSortString("bcafg", "abcd"));

    }

    // public static String customSortString(String order, String s) {
    //     StringBuilder matching = new StringBuilder();
    //     Set<Character> orderSet = new HashSet<>();

    //     // store all characters of order for quick lookup
    //     for (char c : order.toCharArray()) {
    //         orderSet.add(c);
    //     }

    //     // Step 1: for each char in order, append all matching chars from s
    //     for (int i = 0; i < order.length(); i++) {
    //         char current = order.charAt(i);
    //         for (int j = 0; j < s.length(); j++) {
    //             if (s.charAt(j) == current) {
    //                 matching.append(current);
    //             }
    //         }
    //     }

    //     // Step 2: append remaining characters not in order
    //     for (int j = 0; j < s.length(); j++) {
    //         char ch = s.charAt(j);
    //         if (!orderSet.contains(ch)) {
    //             matching.append(ch);
    //         }
    //     }

    //     return matching.toString();
    // }

    // Optimal approach:

    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        int[] ca = new int[26];

        for (char i : order.toCharArray()) {
            set.add(i);
        }

        for (char i : s.toCharArray()) {
            if (!set.contains(i)) {
                sb.append(i);
            } else {
                ca[i - 'a']++;
            }
        }

        for (char c : order.toCharArray()) {
            int i = ca[c - 'a'];
            while(i-- > 0) {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}