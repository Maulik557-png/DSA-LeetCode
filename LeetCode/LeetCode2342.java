import java.util.HashMap;
import java.util.Map;

public class LeetCode2342 {
    public static void main(String[] args) {
        int[] nums = {51, 71, 17, 42};
        System.out.println(maximumSum(nums));
    }

    public static int maximumSum(int[] nums)    {
        Map<Integer, Integer> map = new HashMap<>();
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int digSum = 0;
            while(n > 0)  {
                digSum += n % 10;
                n = n / 10;
            }
            if(map.containsKey(digSum))  {
                max = Math.max(max, nums[map.get(digSum)] + nums[i]);   
                map.put(digSum, Math.max(map.get(digSum), i));
            }
            else map.put(digSum, i);
        }
        return max;
    }
}
