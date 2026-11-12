public class Nov12P3105 {
    public int longestMonotonicSubarray(int[] nums) {
        int best = 1;
        int up = 1;
        int down = 1;

        for (int i = 1; i < nums.length; i++) {
            up = nums[i - 1] < nums[i] ? up + 1 : 1;
            down = nums[i - 1] > nums[i] ? down + 1 : 1;
            best = Math.max(best, Math.max(up, down));
        }

        return best;
    }
}
