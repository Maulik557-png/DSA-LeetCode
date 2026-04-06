// import java.util.HashSet;
// import java.util.Set;

public class LeetCode3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128]; 
        int res = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            index[ch]++;

            while(index[ch] > 1) {
                index[s.charAt(l)]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    // public static int lengthOfLongestSubstring(String s) {

    //     Set<Character> set = new HashSet<>();
    //     int left = 0;
    //     int maxLen = 0;

    //     for (int right = 0; right < s.length(); right++) {
    //         while (set.contains(s.charAt(right))) {
    //             set.remove(s.charAt(left));
    //             left++;
    //         }

    //         set.add(s.charAt(right));
    //         maxLen = Math.max(maxLen, right - left + 1);
    //     }
    //     return maxLen;
    // }

    // public static int lengthOfLongestSubstring(String s) {
    //     int[] index = new int[128]; 
    //     int maxLen = 0;
    //     int left = 0;

    //     for (int i = 0; i < s.length(); i++) {
    //         char ch = s.charAt(i);

    //         left = Math.max(left, index[ch]);
    //         maxLen = Math.max(maxLen, i - left + 1);
    //         index[ch] = i + 1;
    //     }
    //     return maxLen;
    // }
}
