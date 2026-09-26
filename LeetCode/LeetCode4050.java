import java.util.Arrays;

public class LeetCode4050 {
    public int minDays(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int k = 1;; k++) {
            int sc = (k * (k + 1)) / 2;
            if (sc > n) {
                break;
            }

            int cost = k + 1;

            for (int i = sc; i <= n; i++) {
                if (dp[i - sc] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - sc] + cost);
                }
            }
        }

        return dp[n] - 1;
    }
}
