public class LeetCode334 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (first >= n)
                first = n;
            else if (second >= n)
                second = n;
            else {
                return true;
            }
        }
        return false;
    }

    // O(n log n)
    // public static boolean increasingTriplet(int[] nums) {
    //     return lis(nums) >= 3;
    // }

    // public static int lis(int[] nums) {
    //     int[] arr = new int[nums.length];
    //     int size = 0;
    //     for (int n : nums) {
    //         int l = 0;
    //         int r = size - 1;
    //         int res = size;
    //         while (l <= r) {
    //             int mid = l + (r - l) / 2;
    //             if (arr[mid] >= n) {
    //                 res = mid;
    //                 r = mid - 1;
    //             } else {
    //                 l = mid + 1;
    //             }
    //         }
    //         arr[res] = n;
    //         if (res == size) {
    //             size++;
    //         }
    //     }
    //     return size;
    // }
}
