public class LeetCode487 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0};
        System.out.println(findMaxConsecutiveOnes2(nums));
    }


    public static int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int[] copy = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                    copy[j] = nums[j];
                }
            if(copy[i] == 0)    {

                
                copy[i] = 1;

                count = findMaxConsecutiveOnes(copy);
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static int findMaxConsecutiveOnes(int[] nums)    {

        int count = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)    {
                count++;
                res = (count > res) ? count: res;
            }
            else    count = 0;
        }
        return res;
    }
}
