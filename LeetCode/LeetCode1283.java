public class LeetCode1283 {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        System.out.println(smallestDivisor(nums, threshold));
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(nums, mid, threshold)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private static boolean isPossible(int[] nums, int div, int threshold) {
        int sum = 0;
        for (int n : nums) {
            sum += (n + div - 1) / div;
        }
        return sum <= threshold;
    }

    // public int smallestDivisor(int[] nums, int t) {
    //     int max = Integer.MIN_VALUE;
    //     for (int n : nums) {
    //         max = Math.max(max, n);
    //     }

    //     if (t == nums.length) {
    //         return max;
    //     }

    //     int l = 1;
    //     int r = max;
    //     int minDiv = Integer.MAX_VALUE;
    //     while (l <= r) {
    //         int mid = l + (r - l) / 2;
    //         if (isPossible(nums, mid, t)) {
    //             minDiv = Math.min(minDiv, mid);
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //     }
    //     return minDiv;
    // }

    // public static boolean isPossible(int[] nums, int div, int t) {
    //     int sum = 0;
    //     for (int n : nums) {
    //         sum += (n + div - 1) / div;
    //     }
    //     return sum <= t;
    // }
}
