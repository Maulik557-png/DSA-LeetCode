import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode1331 {
    public int[] arrayRankTransform(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        int r = 1;

        for(int x: sorted) {
            if(!map.containsKey(x)) {
                map.put(x, r++);    
            }
        }

        for(int i = 0; i < n; i++) {
            nums[i] = map.get(nums[i]);
        }
 
        return nums;
    }
}
