public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int k) {
        return -1;
    }

    // find the smallest index such that nums[i] >= k
    // Basically the first occurence of any number
    public static int lowerBound(int[] nums, int k) {
        int n = nums.length;
        int res = n;

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    // find the smallest index such that nums[i] > k
    // basically the last occurence of any number + 1
    public static int upperBound(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] > k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
