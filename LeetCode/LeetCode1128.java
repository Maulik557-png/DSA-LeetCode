import java.util.HashMap;
import java.util.Map;

public class LeetCode1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int[] d : dominoes) {
            int min = Math.min(d[0], d[1]);
            int max = Math.max(d[0], d[1]);

            int key = min * 10 + max;

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int n : map.values()) {
            res += (n * (n - 1)) / 2;
        }

        return res;
    }
}