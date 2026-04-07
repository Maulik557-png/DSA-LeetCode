import java.util.HashMap;
import java.util.Map;

public class LeetCode992 {
    public static void main(String[] args) {
        int[] nums = { 1, 2 };
        int k = 1;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        return find(nums, k) - find(nums, k - 1);
    }

    public static int find(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.size() > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            res += i - l + 1;
        }
        return res;
    }

    // public static int subarraysWithKDistinct(int[] nums, int k) {
    // Set<Integer> set;
    // int res = 0;

    // for (int i = 0; i < nums.length; i++) {
    // set = new HashSet<>();
    // for (int j = i; j < nums.length; j++) {
    // set.add(nums[j]);
    // if (set.size() > k)
    // break;
    // if (set.size() == k)
    // res++;
    // }
    // }
    // return res;
    // }
}
