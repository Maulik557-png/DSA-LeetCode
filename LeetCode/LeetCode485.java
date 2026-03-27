package LeetCode;

public class LeetCode485 {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;

        // String s = nums.toString();

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