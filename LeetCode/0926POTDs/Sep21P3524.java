public class Sep21P3524 {
    public long[] resultArray(int[] nums, int k) {
        long[] res = new long[k];
        long[] dp = new long[k];

        for (int num : nums) {
            long[] newDp = new long[k];
            int numMod = num % k;
            newDp[numMod] += 1;

            for (int i = 0; i < k; ++i) {
                if (dp[i] > 0) {
                    int newMod = (i * numMod) % k;
                    newDp[newMod] += dp[i];
                }
            }

            for (int i = 0; i < k; ++i) {
                res[i] += newDp[i];
            }

            dp = newDp;
        }

        return res;
    }
}
