// import java.util.*;

class LeetCode3120 {

    public static void main(String[] args) {
        String s = "aaAbcBC";
        System.out.println(numberOfSpecialChars(s));
    }

    public static int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            }else {
                upper[ch - 'A'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }

        return count;
    }

    // public static int numberOfSpecialChars(String word) {
    //     Set<Character> lower = new HashSet<>();
    //     Set<Character> upper = new HashSet<>();
    //     int count = 0;
    //     for (char ch : word.toCharArray()) {
    //         if (Character.isLowerCase(ch)) {
    //             lower.add(ch);
    //         } else {
    //             upper.add(Character.toLowerCase(ch));
    //         }
    //     }

    //     for (char ch : lower) {
    //         if (upper.contains(ch)) {
    //             count++;
    //         }
    //     }
    //     return count;
    // }
}