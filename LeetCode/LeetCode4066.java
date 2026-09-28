import java.util.HashMap;
import java.util.Map;

public class LeetCode4066 {
    public int maxEqualAdjacentPairs(int[] nums) {
        int base = 0;
        Map<Long, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int u = nums[i];
            int v = nums[i + 1];

            if (u == v) {
                base++;
            } else {
                long min = Math.min(u, v);
                long max = Math.max(u, v);
                long key = (min << 32) | max;

                map.put(key, map.getOrDefault(key, 0) + 1);
            }

        }

        int max = 0;
        for (int n : map.values()) {
            max = Math.max(max, n);
        }

        return base + max;
    }
}
