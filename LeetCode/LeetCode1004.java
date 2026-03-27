package LeetCode;

public class LeetCode1004 {

    public static void main(String[] args) {
        // nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]
        //                        l              r
        // k = 2

        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnes(nums, 2));
    }

    public static int longestOnes(int[] nums, int k) {

        int left = 0;
        int window = 0;
        int res = 0;
        int n = nums.length;

        for (int right = 0; right < n; right++) {

            window += nums[right];
            
            while (window + k < right - left + 1) {
                window -= nums[left];
                left++;

            }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
