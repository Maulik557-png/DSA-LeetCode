package LeetCode;

public class LeetCode424 {
    public static void main(String[] args) {
        // nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
        //                        l              r
        // k = 2

        String s = "AABABBA";
        System.out.println(characterReplacement(s, 1));
    }

    public static int characterReplacement(String s, int k) {

        int[] freq = new int[26];
        int left = 0;
        int window = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'A']++;
            window = Math.max(window, freq[s.charAt(right) - 'A']);
            
            while (k + window < (right - left + 1)) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
