package LeetCode;

public class LeetCode977 {

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] sq = sortedSquares(nums);
        for (int i : sq) {
            System.out.println(i);
        }
    }

    public static int[] sortedSquares(int[] nums) {

        int l = 0;
        int r = nums.length - 1;
        int n = nums.length - 1;

        int[] sq = new int[nums.length];

        while(l <= r && n >= 0)    {
            if(Math.abs(nums[l]) < Math.abs(nums[r]))   {
                sq[n] = nums[r] * nums[r];
                r--;
            }
            else    {
                sq[n] = nums[l] * nums[l];
                l++;
            }
            n--;
        }

        return sq;
    }
}
