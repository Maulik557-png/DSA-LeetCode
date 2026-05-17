public class LeetCode153 {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < min) {
                min = Math.min(min, nums[mid]);
            }
            if (nums[l] < min) {
                min = Math.min(min, nums[l]);
            }
            if (nums[r] < min) {
                min = Math.min(min, nums[r]);
            }
            if (nums[mid] > nums[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return min;
    }

    // Clean
    // public static int findMin(int[] nums) {
    //     int l = 0;
    //     int r = nums.length - 1;

    //     while (l < r) {
    //         int mid = l + (r - l) / 2;

    //         if (nums[mid] > nums[r]) {
    //             l = mid + 1;
    //         } else {
    //             r = mid;
    //         }
    //     }
    //     return nums[l];
    // }
}
