import java.util.Arrays;

public class Sep17P1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int res = Integer.MAX_VALUE;
        int sum = 0;

        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {
                if (l > 0 && best[l - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, best[l - 1] + (r - l + 1));
                }
                best[r] = r - l + 1;
            }

            if (r > 0) {
                best[r] = Math.min(best[r], best[r - 1]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
