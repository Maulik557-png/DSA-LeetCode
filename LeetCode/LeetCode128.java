import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums)  set.add(n);
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                res = Math.max(res, length);
            }
        }
        return res;
    }

    // Won't work
    // public static int longestConsecutive(int[] nums) {
    // Set<Integer> set = new HashSet<>();
    // for(int n: nums) set.add(n);
    // int res = 0;
    // for(int i = 0; i < nums.length; i++) {
    // int l = 1;
    // while(set.contains(nums[i] + l) && l < nums.length) {
    // l++;
    // }
    // if(l == 1) continue;
    // res = Math.max(res, l);
    // while(l >= 0) {
    // l--;
    // set.remove(nums[i] + l);
    // }
    // }
    // return res;
    // }

    // Won't work
    // public static int longestConsecutive(int[] nums) {
    // Set<Integer> set = new HashSet<>();
    // for(int n: nums) set.add(n);
    // int res = 0;
    // for(int i = 0; i < nums.length; i++) {
    // int l = 1;
    // while(set.contains(nums[i] + l) && l < nums.length) {
    // l++;
    // }
    // res = Math.max(res, l);
    // }
    // return res;
    // }
}
