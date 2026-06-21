import java.util.*;

public class LeetCode1657 {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(closeStrings(s1, s2));
    }

    // frequncy count method v1
    public static boolean closeStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : s1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < freq1.length; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq2[i] == 0 && freq1[i] != 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    // HashMap v2
    // public static boolean closeStrings(String s1, String s2) {
    //     if (s1.length() != s2.length()) {
    //         return false;
    //     }

    //     Map<Character, Integer> map1 = new HashMap<>();
    //     Map<Character, Integer> map2 = new HashMap<>();

    //     for (char ch : s1.toCharArray()) {
    //         map1.put(ch, map1.getOrDefault(ch, 0) + 1);
    //     }

    //     for (char ch : s2.toCharArray()) {
    //         map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    //     }

    //     if (!map1.keySet().equals(map2.keySet())) {
    //         return false;
    //     }

    //     int[] v1 = map1.values().stream().mapToInt(Integer::intValue).toArray();
    //     int[] v2 = map2.values().stream().mapToInt(Integer::intValue).toArray();

    //     Arrays.sort(v1);
    //     Arrays.sort(v2);

    //     return Arrays.equals(v1, v2);
    // }

    // HashMap v1
    // public static boolean closeStrings(String s1, String s2) {
    //     if (s1.length() != s2.length()) {
    //         return false;
    //     }

    //     Map<Character, Integer> map1 = new HashMap<>();
    //     Map<Character, Integer> map2 = new HashMap<>();

    //     for (char ch : s1.toCharArray()) {
    //         map1.put(ch, map1.getOrDefault(ch, 0) + 1);
    //     }

    //     for (char ch : s2.toCharArray()) {
    //         map2.put(ch, map2.getOrDefault(ch, 0) + 1);
    //     }

    //     if (!map1.keySet().equals(map2.keySet())) {
    //         return false;
    //     }

    //     int[] v1 = new int[map1.size()];
    //     int[] v2 = new int[map2.size()];

    //     int i = 0;
    //     for (int n : map1.values()) {
    //         v1[i] = n;
    //         i++;
    //     }

    //     int j = 0;
    //     for (int n : map2.values()) {
    //         v2[j] = n;
    //         j++;
    //     }

    //     Arrays.sort(v1);
    //     Arrays.sort(v2);

    //     return Arrays.equals(v1, v2);
    // }
}