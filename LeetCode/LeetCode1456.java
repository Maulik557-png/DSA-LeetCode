public class LeetCode1456 {

    public static void main(String[] args) {

        String s = "LeetCode";
        int k = 3;

        System.out.println(maxVowels(s, k));
    }

    // public static int maxVowels(String s, int k) {
    // int maxCount = 0;
    // int currentCount = 0;

    // for (int i = 0; i < k && i < s.length(); i++) {
    // if (isVowel(s.charAt(i))) {
    // currentCount++;
    // }
    // }

    // maxCount = currentCount;

    // for (int i = k; i < s.length(); i++) {
    // if (isVowel(s.charAt(i - k))) {
    // currentCount--;
    // }
    // if (isVowel(s.charAt(i))) {
    // currentCount++;
    // }

    // maxCount = Math.max(maxCount, currentCount);
    // if (maxCount == k) return k;
    // }

    // return maxCount;
    // }

    // private static boolean isVowel(char c) {
    // return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    // }

    public static int maxVowels(String s, int k) {

        int l = 0, r = 0, res = 0, window = 0;

        for (; r < k; r++) {
            window += isVowel(s.charAt(r));
        }

        res = window;

        if (res == k)
            return k;

        while (r < s.length()) {
            window -= isVowel(s.charAt(l++));
            window += isVowel(s.charAt(r++));
            res = Math.max(res, window);

            if (res == k)
                return k;
        }

        return res;
    }

    private static int isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;
    }
}
