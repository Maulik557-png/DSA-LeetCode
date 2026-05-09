import java.util.*;

public class LeetCode15 {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = threeSum(nums);
        for (List<Integer> l : list) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left++;
                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
    }
    
    // TLE
    // public static List<List<Integer>> threeSum(int[] nums) {
    //     Set<List<Integer>> result = new HashSet<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         int target = -nums[i];
    //         twoSum(nums, target, i, result);
    //     }

    //     return new ArrayList<>(result);
    // }

    // private static void twoSum(int[] nums, int target, int ignore, Set<List<Integer>> result) {
    //     Set<Integer> seen = new HashSet<>();

    //     for (int i = 0; i < nums.length; i++) {
    //         if (i == ignore)
    //             continue;

    //         int complement = target - nums[i];

    //         if (seen.contains(complement)) {
    //             List<Integer> triplet = Arrays.asList(nums[i], complement, -target);
    //             Collections.sort(triplet); // normalize order
    //             result.add(triplet);
    //         }

    //         seen.add(nums[i]);
    //     }
    // }
}
