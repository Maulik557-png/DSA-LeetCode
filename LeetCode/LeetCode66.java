public class LeetCode66 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int[] res = plusOne(nums);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] plusOne(int[] nums1) {
        int[] sum = new int[nums1.length + 1];

        int[] nums2 = {1};

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

        if (sum[0] == 0) return java.util.Arrays.copyOfRange(sum, 1, sum.length);
        return sum;
    }
}
