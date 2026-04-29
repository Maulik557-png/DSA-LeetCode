public class LeetCode238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        for(int i : res)    {
            System.out.println(i);
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int count = 1;
        int left = 1, right = 1;
        int j = 0;
        int k = nums.length - 1;
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++)    {
            count *= nums[i];
            if(nums[i] == 0)    {
                while(j < i)    {left *= nums[j]; j++;}    
                while(k > i)    {right *= nums[k]; k--;}
            }
        }

        for(int i = 0; i < nums.length; i++)    {
            if(nums[i] != 0)    
                res[i] = count/nums[i];
            else    
                res[i] = left * right;
        }

        return res;
    }
}
