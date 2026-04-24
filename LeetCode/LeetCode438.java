import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;

        int[] pCount = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            if (i >= windowSize) 
                window[s.charAt(i - windowSize) - 'a']--;
            if (Arrays.equals(pCount, window)) 
                list.add(i - windowSize + 1);
        }
        return list;
    }

    // public static List<Integer> findAnagrams(String s, String p) {
    //     int[] arr = new int[26];
    //     List<Integer> list = new ArrayList<>();
    //     for(int i = 0; i < p.length(); i++)    {
    //         arr[p.charAt(i) - 'a']++;
    //     }

    //     for(int i = 0; i <= s.length() - p.length(); i++)   {
    //         int[] count = new int[26];
    //         for (char ch : s.substring(i, i + p.length()).toCharArray()) {
    //             count[ch - 'a']++;
    //         }
    //         if(Arrays.equals(arr, count))  list.add(i);
    //     }
    //     return list;
    // }
}
