public class LeetCode713 {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (nums.length == 1)  return (nums[0] < k) ? 1 : 0;
        if (k <= 1) return 0;

        int left = 0;
        int right = 0;

        int window = 1;
        int res = 0;

        for (right = 0; right < nums.length; right++) {

        window *= nums[right];

        while (window >= k) {
            window /= nums[left];
            left++;
        }

        res += right - left + 1;
    }
        return res;
    }
}
