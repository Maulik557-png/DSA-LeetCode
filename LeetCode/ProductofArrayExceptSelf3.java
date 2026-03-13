public class ProductofArrayExceptSelf3 {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: build prefix product
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: multiply suffix product
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,0,3,4};
        int[] res = productExceptSelf(nums);
        for(int i : res)    {
            System.out.println(i);
        }
    }
}
