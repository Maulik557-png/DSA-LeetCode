public class Apr19LeetCode1855 {
    public static void main(String[] args) {
        int[] nums1 = { 55, 30, 5, 4, 2 };
        int[] nums2 = { 100, 20, 10, 10, 5 };
        System.out.println(maxDistance(nums1, nums2));
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, res = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                res = Math.max(res, j - i);
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    // TLE
    // public static int maxDistance(int[] nums1, int[] nums2) {
    //     int res = Integer.MIN_VALUE;
    //     for (int i = 0; i < nums1.length; i++) {
    //         for (int j = nums2.length - 1; j >= i; j--) {
    //             if (nums1[i] <= nums2[j]) {
    //                 res = Math.max(res, j - i);
    //                 break;
    //             }
    //         }
    //     }
    //     return res == Integer.MIN_VALUE ? 0 : res;
    // }
    
    // Broken logic
    // public static int maxDistance(int[] nums1, int[] nums2) {
    //     int res = Integer.MIN_VALUE;

    //     int i = 0;
    //     int k = nums1.length - 1;
    //     int mid = (i + k) / 2;

    //     while (i >= 0 && k < nums1.length) {
    //         mid = (i + k) / 2;
    //         for (int j = nums2.length - 1; j >= mid; j--) {
    //             if (nums1[mid] <= nums2[j]) {
    //                 res = Math.max(res, j - mid);
    //                 k = mid;
    //                 break;
    //             } else {
    //                 i = mid;
    //             }
    //         }
    //     }
    //     return res == Integer.MIN_VALUE ? 0 : res;
    // }
}
