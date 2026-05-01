public class LeetCode268 {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums)  {
        int sum = (nums.length * (nums.length + 1)) / 2;
        for(int n: nums)  sum -= n;
        return sum;
    }
}
