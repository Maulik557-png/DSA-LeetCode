// Solution is not approved!!
// Time Limit Exceeded for imagine 1000000000 inputs

public class ProductofArrayExceptSelf2 {
    public static int[] productExceptSelf(int[] nums) {
        
        int left = 1;
        int right = 1;
        int[] res = new int[nums.length];
        
        for(int i = 0; i < nums.length-1; i++)    {
            left = 1;
            right = 1;
            for(int j = 0; j < i; j++)  {
                left *= nums[j];
            }
            for(int k = nums.length - 1; k > i; k--)    {
                right *= nums[k];
            }
            res[i] = left * right;    
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {};
        int[] res = productExceptSelf(nums);
        for(int i : res)    {
            System.out.println(i);
        }
    }
}
