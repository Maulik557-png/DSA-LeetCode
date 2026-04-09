public class LeetCode1343 {
    public static void main(String[] args) {
        int[] nums = {11,13,17,23,29,31,7,5,2,3};
        System.out.println(numOfSubarrays(nums, 3, 5));
    }

    public static int numOfSubarrays(int[] nums, int k, int limit) {
        int l = 0, r = 0;

        int sum = 0;
        int count = 0;

        for(; r < k; r++)   {
            sum += nums[r];
        }

        if(sum / k >= limit)  count++;

        while(r < nums.length)    {
            sum += nums[r++] - nums[l++];
            if(sum / k >= limit)  count++;
        }
        return count;
    }
}
