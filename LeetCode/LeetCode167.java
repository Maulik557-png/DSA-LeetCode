public class LeetCode167 {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int res[] = twoSum(nums, target);

        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i < j)   {
            if(nums[i] + nums[j] > target)   j--;
            else if(nums[i] + nums[j] < target)    i++;
            else    return new int[]{i + 1, j + 1};
        }

        return null;
    }
}
