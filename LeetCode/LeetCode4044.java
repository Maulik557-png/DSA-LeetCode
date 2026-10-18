public class LeetCode4044 {
    public int countGoodRotations(int[] nums) {
        long s1 = 0;
        long s2 = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                s1 += nums[i];
            } else {
                s2 += nums[i];
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            if (s1 > s2) {
                res++;
            }

            int f = nums[i];
            int l = nums[(i + (n / 2)) % n];

            s1 = s1 - f + l;
            s2 = s2 - l + f;
        }

        return res;
    }
}
