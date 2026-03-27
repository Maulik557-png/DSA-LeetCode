package LeetCode;

public class LeetCode283 {
    
    // public static void moveZeroes(int[] nums) {
        
    //     int[] array = new int[nums.length];

    //     int j = 0;
    //     int k = 0;

    //     for (int i = 0; i < nums.length; i++) {

    //         if (nums[i] != 0) {
    //             array[j] = nums[i];
    //             j++;
    //         } 
    //     }

    //     for (int i = 0; i < nums.length; i++) {
    //         nums[i] = array[k];
    //         k++;
    //     }
    // }

    public static void moveZeroes(int[] nums) {
        int write = 0; // position to place the next non-zero element

        // move all non-zero elements to the front
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }

        // fill the remaining positions with zeros
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    public static void main(String[] args) {
        
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        for (int i : nums) {
            System.out.print(i + ", ");
        }
    }
}
