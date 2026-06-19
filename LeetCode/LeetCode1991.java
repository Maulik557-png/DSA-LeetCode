public class LeetCode1991 {
    public static void main(String[] args) {
        int[] nums = { 2, 1, -1 };
        System.out.println(findMiddleIndex(nums));
    }

    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int left = prefix[i];
            int right = prefix[n] - prefix[i + 1];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
}
