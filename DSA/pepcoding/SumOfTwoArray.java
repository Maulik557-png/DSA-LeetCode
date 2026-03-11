public class SumOfTwoArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,4,5,3,5,5,6};

        int[] sum = sumOfArray(nums1, nums2);
        
        for (int i : sum) {
            System.out.print(i);
        }
    }

    private static int[] sumOfArray(int[] nums1, int[] nums2)   {
        int[] sum = new int[nums1.length > nums2.length? nums1.length: nums2.length];

        int i = nums1.length - 1;
        int j = nums2.length - 1;
        int k = sum.length - 1;
        int carry = 0;

        while(k >= 0)   {
            int digit = carry;

            if(i >= 0)  digit += nums1[i];
            if(j >= 0)  digit += nums2[j];

            sum[k] = digit % 10;
            carry = digit / 10;

            i--;
            j--;
            k--;
        }

        if(carry != 0)  System.out.print(carry);

        return sum;
    }
}
