public class LeetCode4043 {
    public int countRotations(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] sc = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            sc[i] = getScore(sb.toString());

            char ch = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(ch);
        }

        int res = 0;
        for (int n : sc) {
            if (n == k) {
                res++;
            }
        }

        return res;
    }

    public int getScore(String s) {
        int sc = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                sc++;
            }
        }

        return sc;
    }
}
