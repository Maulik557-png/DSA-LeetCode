public class LeetCode4083 {
    public int minDeletions(int[] nums) {
        int del = 0;
        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                del++;
            } else {
                prev = nums[i];
            }
        }

        return del;
    }
}
