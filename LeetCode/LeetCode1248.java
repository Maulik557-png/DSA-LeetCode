import java.util.HashMap;
import java.util.Map;

public class LeetCode1248 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;
        int curr = 0;

        for (int n : nums) {
            curr += n % 2;
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            res += map.getOrDefault(curr - k, 0);
        }

        return res;
    }

    // public static int numberOfSubarrays(int[] nums, int k) {
    // int l = 0;
    // int ans = 0;
    // int count = 0;
    // int temp = 0;

    // for (int r = 0; r < nums.length; r++) {
    // if (nums[r] % 2 != 0) {
    // count++;
    // temp = 0; // reset temp when new odd comes
    // }

    // while (count == k) {
    // temp++; // count valid starting points
    // if (nums[l] % 2 != 0)
    // count--;
    // l++;
    // }
    // ans += temp;
    // }
    // return ans;
    // }

    // public static int numberOfSubarrays(int[] nums, int k) {
    // return find(nums, k) - find(nums, k - 1);
    // }

    // public static int find(int[] nums, int k) {
    // int l = 0;
    // int r = 0;
    // int res = 0;
    // int count = 0;

    // for (; r < nums.length; r++) {
    // if(nums[r] % 2 != 0) {
    // count++;
    // }
    // while ( count > k) {
    // if(nums[l] % 2 != 0) {
    // count--;
    // }
    // l++;
    // }
    // res += r - l + 1;
    // }
    // return res;
    // }
}
