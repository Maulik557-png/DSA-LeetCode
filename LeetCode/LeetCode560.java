import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    public static void main(String[] args) {
        int[] nums = {1,-1,0};
        int k = 0;
        System.out.println(subarraySum(nums, k));
    }   

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int curr = 0;
        map.put(0,1);

        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            count += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return count;
    }

    // public static int subarraySum(int[] nums, int k) {
    //     int[] prefixSum = new int[nums.length];
    //     prefixSum[0] = nums[0];
    //     int count = 0;
    //     for (int i = 1; i < nums.length; i++)  prefixSum[i] = prefixSum[i - 1] + nums[i];

    //     Map<Integer, Integer> map = new HashMap<>();
    //     map.put(0,1);
    //     for (int i = 0; i < prefixSum.length; i++) {
    //         count += map.getOrDefault(prefixSum[i] - k, 0);
    //         map.put(prefixSum[i], map.getOrDefault(prefixSum[i], 0) + 1);
    //     }
    //     return count;
    // }

    // Sliding window will never work here
    // public static int subarraySum(int[] nums, int k) {
    //     int left = 0;
    //     int right = 0;
    //     int window = 0;
    //     int count = 0;

    //     for(; right < nums.length; right++)  {
    //         window += nums[right];

    //         while(window > k && left < nums.length)  {
    //             window -= nums[left];
    //             left++;
    //         }
    //         if(window == k)  count++;
    //     }
    //     return count;
    // }
}
