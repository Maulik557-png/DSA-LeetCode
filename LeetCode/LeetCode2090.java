package LeetCode;

import java.util.Arrays;

public class LeetCode2090   {

    public static void main(String[] args) {
        int[] nums = {40527,53696,10730,66491,62141,83909,78635,18560};
        int k = 2;
        int[] res = getAverages(nums, k);

        for (int i : res) {
            System.out.println(i);
        }
    }

    private static int[] getAverages(int[] nums, int k) {

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        if(k == 0)  return nums;

        if(k > nums.length / 2)  return res;

        int l = 0;
        int r = 2 * k;

        int pivot = k;

        while(r < nums.length)  {

            int avg = 0;
            
            for(int i = l; i <= r; i++) {
                avg += nums[i];
            }
            res[pivot] = avg / (2 * k + 1);

            r++;
            l++;
            pivot++;
        }
        return res;
    }
}