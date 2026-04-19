import java.util.HashMap;
import java.util.Map;
// import java.util.HashSet;
// import java.util.Set;

public class LeetCode523 {

    public static void main(String[] args) {
        int[] nums = { 5,0,0,0 };
        int k = 3;
        System.out.println(checkSubarraySum(nums, k));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // important

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;

            if (rem < 0)
                rem += k;

            if (map.containsKey(rem)) {
                if (i - map.get(rem) > 1) {
                    return true;
                }
            } else {
                map.put(rem, i); // store first occurrence
            }
        }

        return false;
    }

    /*
     * WRONG APPROCH
     * public static boolean checkSubarraySum(int[] nums, int k) {
     * int[] prefixMod = new int[nums.length];
     * prefixMod[0] = nums[0] % k;
     * 
     * for(int i = 1; i < nums.length; i++) {
     * prefixMod[i] = (prefixMod[i - 1] + nums[i]) % k;
     * }
     * Set<Integer> set = new HashSet<>();
     * 
     * for(int n: prefixMod) {
     * if(!set.add(n))
     * return true;
     * }
     * return false;
     * }
     */

    /*
     * Worst approch
     * public static boolean checkSubarraySum(int[] nums, int k) {
     * if(nums.length ==0) return false;
     * if(nums.length == 2) return ((nums[0] + nums[1]) % k) == 0;
     * 
     * int winSize = 2;
     * 
     * while(winSize < nums.length) {
     * if(slidingWindow(nums, winSize, k)) {
     * return true;
     * } else {
     * winSize++;
     * }
     * }
     * return false;
     * }
     * 
     * public static boolean slidingWindow(int[] nums, int winSize, int k) {
     * int l = 0;
     * int r = winSize;
     * int win = 0;
     * 
     * for (int i = 0; i < winSize; i++) {
     * win += nums[i];
     * }
     * 
     * for (; r < nums.length; r++) {
     * if (win % k == 0)
     * return true;
     * win += nums[r];
     * win -= nums[l];
     * l++;
     * }
     * return false;
     * }
     */
}
