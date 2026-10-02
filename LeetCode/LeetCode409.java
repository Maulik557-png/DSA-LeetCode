public class LeetCode409 {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int even = 0;
        int odd = 0;

        for (int n : freq) {
            if (n % 2 == 0) {
                even += n;
            } else {
                even += n - 1;
                odd++;
            }
        }

        return (odd > 0) ? even + 1 : even;
    }
}
