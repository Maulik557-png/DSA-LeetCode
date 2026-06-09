public class LeetCode283 {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void moveZeroes(int[] nums) {
        int l = 0;
        int r = 0;

        while (r < nums.length) {
            if (nums[r] != 0) {
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
            r++;
        }
    }

    // public static void moveZeroes(int[] nums) {
    //     int write = 0;

    //     for (int read = 0; read < nums.length; read++) {
    //         if (nums[read] != 0) {
    //             nums[write] = nums[read];
    //             write++;
    //         }
    //     }

    //     while (write < nums.length) {
    //         nums[write] = 0;
    //         write++;
    //     }
    // }
}
