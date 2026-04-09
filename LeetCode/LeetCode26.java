public class LeetCode26 {

    public static void main(String[] args) {
        int[] array = {1,2,3,3,4,5,5};
        
        System.out.println(removeDuplicates(array));

    }
    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int j = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1])  {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
