import java.util.*;

public class TwoSumProblemSolution4 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{ seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 7, 11};
        int target = 9;
        int[] solution = twoSum(nums, target);

        System.out.println(Arrays.toString(solution));
    }
}
