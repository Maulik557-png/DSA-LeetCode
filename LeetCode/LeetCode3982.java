public class LeetCode3982 {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;

        int[][] digits = new int[n][];

        for(int i = 0; i < n; i++) {
            int n1 = nums[i];
            digits[i] = new int[]{0, 9};
            while(n1 > 0) {
                digits[i][0] = Math.max(digits[i][0], n1 % 10);
                digits[i][1] = Math.min(digits[i][1], n1 % 10);
                n1 = n1 / 10;
            }
        }

        int maxDiff = Integer.MIN_VALUE;
        for(int[] diff: digits) {
            maxDiff = Math.max(diff[0] - diff[1], maxDiff);
        }

        
        int res = 0;
        int idx = 0;
        for(int[] diff: digits) {
            if((diff[0] - diff[1]) >= maxDiff) {
                res += nums[idx];
            }
            idx++;
        }
        return res;
    }
}
