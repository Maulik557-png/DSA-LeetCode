public class LeetCode567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] count = new int[26];
        for (char ch : s1.toCharArray()) {
            count[ch - 'a']++;
        }
        int left = 0;
        int right = 0;
        int window = s1.length();

        while (right < s2.length()) {
            if (count[s2.charAt(right) - 'a'] > 0) {
                window--;
            }
            count[s2.charAt(right) - 'a']--;
            right++;
            if (window == 0)
                return true;

            if (right - left == s1.length()) {
                if (count[s2.charAt(left) - 'a'] >= 0) {
                    window++;
                }
                count[s2.charAt(left) - 'a']++;
                left++;
            }
        }
        return false;
    }
}
