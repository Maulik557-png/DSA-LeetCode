import java.util.Arrays;

public class LeetCode4093 {
    public long maximizeSum(int[] nums, int k) {
        int n = nums.length;
        long orgSum = 0;

        long[] gain = new long[n];

        for (int i = 0; i < n; i++) {
            orgSum += nums[i];

            char[] digits = String.valueOf(nums[i]).toCharArray();
            Arrays.sort(digits);

            long max = 0;
            for (int j = digits.length - 1; j >= 0; j--) {
                max = max * 10 + (digits[j] - '0');
            }

            gain[i] = max - nums[i];
        }

        Arrays.sort(gain);

        long res = orgSum;

        for (int i = n - 1; i >= n - k; i--) {
            res += gain[i];
        }

        return res;
    }
}
