import java.util.LinkedHashMap;
import java.util.Map;

public class LeetCode4094 {
    public int countStaircase(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new LinkedHashMap<>();

            for (int j = i; j < nums.length; j++) {
                int x = nums[j];
                map.put(x, map.getOrDefault(x, 0) + 1);

                int k = 1;
                boolean valid = true;

                for (int count : map.values()) {
                    if (count != k++) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    res++;
                }
            }
        }

        return res;
    }
}
