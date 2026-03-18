public class LeetCode421 {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        int left = 0;
        int res = 0;

        for(; left < nums.length; left++) {
            int right = left + 1;
            while(right < nums.length)   {
                res = Math.max(res, (nums[left] ^ nums[right]));
                right++;
            }
        }
        return res;
    }

    // public int findMaximumXOR(int[] nums) {
    //     int left = 0;
    //     int right = 0;
    //     int res = 0;

    //     int or = 0;

    //     for(; right < nums.length; right++) {
    //         or = nums[left] ^ nums[right];
    //         while((or < res) && left < right)   {
    //             left++;
    //             or = nums[left] ^ nums[right];
    //         }
    //         res = Math.max(res, or);
    //     }
    //     return res;
    // }
}
