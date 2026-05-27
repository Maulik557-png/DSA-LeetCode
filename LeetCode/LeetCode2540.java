public class LeetCode2540 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {2,3,4,5};
        System.out.println(getCommon(nums1, nums2));
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    // public static int getCommon(int[] nums1, int[] nums2) {
    //     if(nums1[0] > nums2[0]) {
    //         for(int n: nums1) {
    //             int res = binarySearch(nums2, n);
    //             if(res != -1) {
    //                 return res;
    //             }
    //         }
    //     } else {
    //         for(int n: nums2) {
    //             int res = binarySearch(nums1, n);
    //             if(res != -1) {
    //                 return res;
    //             }
    //         }
    //     }
    //     return -1;
    // }

    // private static int binarySearch(int[] nums, int target) {
    //     int n = nums.length;
    //     int l = 0;
    //     int r = n - 1;
    //     while (l <= r) {
    //         int mid = l + (r - l) / 2;
    //         if (nums[mid] == target) {
    //             return nums[mid];
    //         }
    //         if (nums[mid] > target) {
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //     }
    //     return -1;
    // }
}
