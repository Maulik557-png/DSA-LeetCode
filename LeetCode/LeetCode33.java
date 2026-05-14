public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = { 1 };
        int target = 0;
        System.out.println(search(nums, target));
    }

    // Binary search approach
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] == target) return mid;

            if(nums[mid] >= nums[l]) {
                if(target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if(target <= nums[r] && target >= nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }

    // Works fine and better than linear search still nearly O(n) though in worst case
    // public static int search(int[] nums, int target) {
    //     int n = nums.length;
    //     int r = n - 1;
    //     int res = -1;
    //     int i = 0;

    //     if (target <= nums[r]) {
    //         i = r;
    //         while (i >= 0 && nums[r] >= nums[i]) {
    //             if (nums[i] == target) {
    //                 res = i;
    //                 return res;
    //             }
    //             i--;
    //         }
    //     } else {
    //         i = 0;
    //         while (i < n && nums[i] >= nums[r]) {
    //             if (nums[i] == target) {
    //                 res = i;
    //                 return res;
    //             }
    //             i++;
    //         }
    //     }
    //     return -1;
    // }
}
