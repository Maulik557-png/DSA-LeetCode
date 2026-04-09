import java.util.HashMap;
import java.util.Map;

public class LeetCode974 {
    public static void main(String[] args) {
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }

    public static int subarraysDivByK(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int curr = 0;
    map.put(0,1);

    for (int i = 0; i < nums.length; i++) {
    curr += nums[i];

    int rem = curr % k;
    if (rem < 0) rem += k;

    count += map.getOrDefault(rem, 0);
    map.put(rem, map.getOrDefault(rem, 0) + 1);
    }
    return count;
    }

    // public static int subarraysDivByK(int[] nums, int k) {
    //     int n = nums.length;
    //     int sum = 0;
    //     int c = 0;
    //     int freq[] = new int[k];
    //     freq[0]++;
    //     for (int i = 0; i < n; i++) {
    //         sum += nums[i];
    //         int rem = sum % k;
    //         if (rem < 0)
    //             rem += k;
    //         c += freq[rem];
    //         freq[rem]++;
    //     }
    //     return c;
    // }
}
