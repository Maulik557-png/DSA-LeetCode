public class LeetCode4025 {
    public static int maximumGap(String sk, String st) {
        if (sk.length() == 1) {
            return 0;
        }

        int n = sk.length();

        int[] left = new int[n];
        int[] right = new int[n];

        int j = 0;
        for (int i = 0; i < n; i++) {
            while (st.charAt(j) != sk.charAt(i)) {
                j++;
            }

            left[i] = j;
            j++;
        }

        j = st.length() - 1;
        for (int i = n - 1; i >= 0; i--) {
            while (st.charAt(j) != sk.charAt(i)) {
                j--;
            }

            right[i] = j;
            j--;
        }

        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            res = Math.max(res, right[i + 1] - left[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumGap("caa", "acaa"));
    }
}
