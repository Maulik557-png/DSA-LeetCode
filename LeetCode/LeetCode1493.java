package LeetCode;

public class LeetCode1493 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1 };
        System.out.println(longestSubarray(nums));
    }

    // public static int longestSubarray(int[] nums) {
    // int left = 0;
    // int window = 0;
    // int right = 0;
    // int res = 0;

    // for(; right < nums.length; right++) {
    // int length = right - left + 1;
    // window += nums[right];

    // while(window < length + 1 && left < right) {
    // window -= nums[left];
    // left++;
    // }

    // res = Math.max(res, length + 1);
    // }
    // return res;
    // }

    public static int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int count = 0;
        int res = 0;

        for (; right < nums.length; right++) {

            if (nums[right] == 0)  count++;

            while (count > 1) {
                if (nums[left] == 0)  count--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
