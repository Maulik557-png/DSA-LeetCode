package LeetCode;

import java.util.Arrays;

public class LeetCode1679 {

    // public static int maxOperations(int[] nums, int k) {

    //     int ops = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         if(nums[i] < k && nums[i] != 0) {
    //             int var = i;
    //             for (int j = i + 1; j < nums.length; j++) {
    //                 if (((k - nums[i]) == nums[j]) && nums[j] < k && nums[j] != 0) {
    //                     nums[i] = 0;
    //                     nums[j] = 0;
    //                     var++;
    //                     ops++;
    //                 }
    //             }
    //         }
    //     }
    //     return ops;
    // }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, ops = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                ops++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return ops;
    }

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4};
        int k = 5;

        System.out.println(maxOperations(nums, k));

    }
}
