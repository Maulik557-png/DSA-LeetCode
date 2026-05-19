public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] res =  searchRange(nums, target);
        System.out.println(res[0] + ", " + res[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        if(n == 0) {
            return new int[]{-1, -1};
        }
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);
        res[1] = ub - 1;

        if (lb == n || nums[lb] != target) {
            return new int[] {-1, -1};
        } else {
            res[0] = lb;
        }
        return res;
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

    // find the smallest index such that nums[i] > k
    // basically the last occurence of any number + 1
    public static int upperBound(int[] nums, int k) {
        int n = nums.length;
        int res = n;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
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
