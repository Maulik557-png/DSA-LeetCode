public class Nov19P2567 {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        int n1 = nums[n - 1] - nums[2];
        int n2 = nums[n - 2] - nums[1];
        int n3 = nums[n - 3] - nums[0];

        return Math.min(n1, Math.min(n2, n3));
    }
}
