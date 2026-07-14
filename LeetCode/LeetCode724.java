public class LeetCode724 {
    public static void main(String[] args) {
        int[] nums = { 2, 1, -1 };
        System.out.println(pivotIndex(nums));
    }

    // ChatGPT version
    public static int pivotIndex(int[] nums) {
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

    // My version
    // public static int pivotIndex(int[] nums) {
    //     int n = nums.length;
    //     int[] prefix = new int[n + 2];
    //     for (int i = 1; i < n + 1; i++) {
    //         prefix[i] = prefix[i - 1] + nums[i - 1];
    //     }

    //     for (int i = 1; i < n + 1; i++) {
    //         if ((prefix[i] - nums[i - 1]) == (prefix[n] - prefix[i])) {
    //             return i - 1;
    //         }
    //     }
    //     return -1;
    // }
}
