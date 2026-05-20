public class LeetCode1539 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int k = 2;
        System.out.println(findKthPositive(nums, k));
    }

    // O(log n)
    public static int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l + k;
    }

    // O(n)
    // public static int findKthPositive(int[] arr, int k) {
    //     int current = 1;
    //     for (int num : arr) {
    //         if (num - current >= k) {
    //             return current + k - 1;
    //         }
    //         k -= (num - current);
    //         current = num + 1;
    //     }
    //     return current + k - 1;
    // }

    // O(ans * n)
    // public static int findKthPositive(int[] nums, int k) {
    //     int count = 0;
    //     int i = 0;
    //     while (count < k) {
    //         i++;
    //         if (!bs(nums, i)) {
    //             count++;
    //         }
    //     }
    //     return i;
    // }

    // private static boolean bs(int[] nums, int target) {
    //     int n = nums.length;
    //     int l = 0;
    //     int r = n - 1;
    //     while (l <= r) {
    //         int mid = l + (r - l) / 2;
    //         if (nums[mid] == target) {
    //             return true;
    //         }
    //         if (nums[mid] > target) {
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //     }
    //     return false;
    // }
}
