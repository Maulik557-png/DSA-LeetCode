import java.util.HashSet;
import java.util.Set;

public class LeetCode219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    // public static boolean containsNearbyDuplicate(int[] nums, int k) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (!set.add(nums[i]))  return true;
    //         if (i >= k)  set.remove(nums[i - k]);
    //     }
    //     return false;
    // }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    // public boolean containsNearbyDuplicate(int[] nums, int k) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         if (map.containsKey(nums[i]))  if (i - map.get(nums[i]) <= k)  return true;
    //         map.put(nums[i], i);
    //     }
    //     return false;
    // }
}
