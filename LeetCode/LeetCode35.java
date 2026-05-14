public class LeetCode35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int k = 5;
        System.out.println(searchInsert(nums, k));
    }

    public static int searchInsert(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        int l = 0;
        int r = n - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(nums[mid] >= k) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
