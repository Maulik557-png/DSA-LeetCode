public class LeetCode238 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] res = productExceptSelf(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    // O (1) space
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }

        return res;
    }

    // O(n) space
    // public static int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] left = new int[n + 2];
    //     int[] right = new int[n + 2];
    //     int l = 1;
    //     Arrays.fill(left, 1);
    //     for (int i = 0; i < nums.length; i++) {
    //         l *= nums[i];
    //         left[i + 1] = l;
    //     }
    //     int r = 1;
    //     Arrays.fill(right, 1);
    //     for (int i = nums.length - 1; i >= 0; i--) {
    //         r *= nums[i];
    //         right[i + 1] = r;
    //     }
    //     int[] res = new int[n];
    //     for (int i = 0; i < res.length; i++) {
    //         res[i] = left[i] * right[i + 2];
    //     }
    //     return res;
    // }
}
