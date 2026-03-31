package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode169 {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        int k = Math.floorDiv(nums.length, 2);
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            if (!set.add(nums[i]))  if(count++ >= k)  return nums[i];
        }
        return 0;
    }
}
