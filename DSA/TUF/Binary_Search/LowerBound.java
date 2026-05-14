package DSA.TUF.Binary_Search;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 5, 5, 6, 7 };
        int target = 5;
        System.out.println(lowerBound(nums, target));
    }

    // find the smallest index such that nums[i] >= k
    // Basically the first occurence of any number
    public static int lowerBound(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
