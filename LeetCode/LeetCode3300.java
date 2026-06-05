public class LeetCode3300 {
    public static void main(String[] args) {
        int[] nums = { 10, 12, 13, 14 };
        System.out.println(minElement(nums));
    }

    public static int minElement(int[] nums) {
        int[] sum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int s = 0;
            while (n > 0) {
                s += (n % 10);
                n /= 10;
            }
            sum[i] = s;
        }
        int res = Integer.MAX_VALUE;
        for (int n : sum) {
            res = Math.min(res, n);
        }
        return res;
    }
}