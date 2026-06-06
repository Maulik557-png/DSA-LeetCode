import java.util.HashMap;
import java.util.Map;

public class LeetCode852 {
    public static void main(String[] args) {
        int[] nums = { 0, 10, 5, 2 };
        System.out.println(peakIndexInMountainArray(nums));
    }

    public static int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        if (nums[0] > nums[1]) {
            max = Math.max(max, nums[0]);
            map.put(max, 0);
        } else if (nums[n - 1] > nums[n - 2]) {
            max = Math.max(max, nums[n - 1]);
            map.put(max, n - 1);
        }
        int l = 1;
        int r = n - 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                max = Math.max(max, nums[mid]);
                map.put(max, mid);
            }
            if (nums[mid] > nums[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return map.get(max);
    }

    // Clean
    // public static int peakIndexInMountainArray(int[] arr) {
    //     int l = 0;
    //     int r = arr.length - 1;

    //     while (l < r) {
    //         int mid = l + (r - l) / 2;

    //         if (arr[mid] < arr[mid + 1]) {
    //             l = mid + 1;
    //         } else {
    //             r = mid;
    //         }
    //     }

    //     return l;
    // }
}
