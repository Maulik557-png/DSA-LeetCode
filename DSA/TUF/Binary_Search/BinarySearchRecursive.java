package DSA.TUF.Binary_Search;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int target = 5;
        int l = 0;
        int r = nums.length - 1;
        System.out.println(binarySearch(nums, l, r, target));
    }

    // O(log n)
    private static int binarySearch(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] >= target) {
            return binarySearch(nums, l, mid - 1, target);
        } else {
            return binarySearch(nums, mid + 1, r, target);
        }
    }
}
