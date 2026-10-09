import java.util.Map;
import java.util.TreeMap;

public class LeetCode4065 {
    public int[] rearrangeArray(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;

        for (int n : map.values()) {
            max = Math.max(max, n);
        }

        int[] res = new int[nums.length];

        int i = 0;
        for (int j = 0; j < max; j++) {
            for (int n : map.keySet()) {

                if (map.get(n) <= 0) {
                    continue;
                }
                res[i++] = n;
                map.put(n, map.get(n) - 1);
            }
        }

        return res;
    }
}
