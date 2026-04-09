public class LeetCode1658 {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        System.out.println(minOperations(nums, x));
    }

    // public static int minOperations(int[] nums, int x) {

    //     int left = 0;
    //     int right = nums.length - 1;
    //     int res = -1;
    //     int window = 0;

    //     while (left < right) {
    //         if (window != x) {
    //             window += nums[left];
    //             res++;
    //             left++;
    //         } else if (window != x) {
    //             window += nums[right];
    //             res++;
    //             right--;
    //         } else
    //             res = -1;
    //     }

    //     return res;
    // }

    public static int minOperations(int[] nums, int x) {

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0)  return -1;
        if (target == 0)  return nums.length;

        int left = 0;
        int window = 0;
        int res = -1;

        for (int right = 0; right < nums.length; right++) {
            window += nums[right];

            while (window > target) {
                window -= nums[left++];
            }
            if (window == target)  res = Math.max(res, right - left + 1);
        }
        return res == -1 ? -1 : nums.length - res;
    }
}
