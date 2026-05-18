package DSA.TUF.Binary_Search;

public class Floor {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 5, 5, 6, 7 };
        int target = 5;
        System.out.println(findFloor(nums, target));
    }

    public static int findFloor(int[] nums, int k) {
        int n = nums.length;
        int res = -1;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= k) {
                res = nums[mid];
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
