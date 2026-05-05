public class LeetCode41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int ind = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[ind];
                nums[ind] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
