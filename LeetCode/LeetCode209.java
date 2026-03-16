public class LeetCode209 {
    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 7, 2};
        int target = 13;

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int res = nums.length + 1;
        int window = 0;
        int l = 0;

        for (int right = 0; right < nums.length; right++) {
            window += nums[right];

            while(window >= target)  {
                res = Math.min(res, right - l + 1);
                window -= nums[l++];
            }
        }
        return res == nums.length + 1 ? 0: res;
    }
}
