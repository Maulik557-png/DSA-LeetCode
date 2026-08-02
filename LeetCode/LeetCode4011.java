public class LeetCode4011 {
    public int countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        int res = 0;

        for (int l = 0; l < n; l++) {
            int x = 0;
            int y = 0;
            for (int r = l; r < n; r++) {
                if (nums[r] % 2 == 0) {
                    x++;
                } else {
                    y++;
                }

                if (y > 0) {
                    if ((long) x * b <= (long) y * a)
                        res++;
                }
            }
        }
        return res;
    }
}
