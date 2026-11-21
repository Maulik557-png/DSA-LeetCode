public class LeetCode4006 {
    public int countValidPrefixes(String s) {

        int res = 0;
        int win = 0;

        for (int r = 0; r < s.length(); r++) {

            win += Character.getNumericValue(s.charAt(r));

            if ((r + 1) % 2 == 0) {
                if (win == (r + 1) / 2) {
                    res++;
                }
            } else {
                if (win == (r + 1) / 2 || win == ((r + 1) / 2) + 1) {
                    res++;
                }
            }
        }
        return res;
    }
}
