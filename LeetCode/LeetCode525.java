import java.util.HashMap;
import java.util.Map;

public class LeetCode525 {

    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};   
        System.out.println(findMaxLength(nums));
    }

    // public static int findMaxLength(int[] nums) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     map.put(0, -1); // important

    //     int curr = 0;
    //     int res = 0;

    //     for (int i = 0; i < nums.length; i++) {
    //         curr += (nums[i] == 0 ? -1 : 1);

    //         if (map.containsKey(curr)) {
    //             res = Math.max(res, i - map.get(curr));
    //         } else {
    //             map.put(curr, i);
    //         }
    //     }
    //     return res;
    // }

    public static int findMaxLength(int[] nums) {
        for(int i = 0; i < nums.length; i++) if(nums[i] == 0) nums[i] = -1;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int curr = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if(map.containsKey(curr)) {
                res = Math.max(res, i - map.get(curr));
            } else {
                map.put(curr, i);
            }
        }
        return res;
    }
}
