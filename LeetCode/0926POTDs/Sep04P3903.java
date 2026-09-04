import java.util.HashMap;
import java.util.Map;

public class Sep04P3903 {
    public int firstStableIndex(int[] nums, int k) {
        Map<Integer, Integer> minMap = new HashMap<>();
        Map<Integer, Integer> maxMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                max = n;
            }
            maxMap.put(i, max);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            if (n < min) {
                min = n;
            }
            minMap.put(i, min);
        }

        for (int i = 0; i < nums.length; i++) {
            int sc = maxMap.get(i) - minMap.get(i);

            if (sc <= k) {
                return i;
            }
        }

        return -1;
    }

    public int firstStableIndexx(int[] nums, int k) {
        int n = nums.length;

        int[] maxArr = new int[n];
        int[] minArr = new int[n];

        maxArr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], nums[i]);
        }

        minArr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minArr[i] = Math.min(minArr[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (maxArr[i] - minArr[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
