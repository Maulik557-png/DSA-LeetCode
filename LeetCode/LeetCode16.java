import java.util.*;

public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int nt = target;
        int min = Integer.MAX_VALUE;
        int res = 0;

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int n1 = nums[i];
            nt = target - n1;

            int l = i + 1;
            int r = n - 1;

            while(l < r) {
                int n2 = nums[l];
                int n3 = nums[r];

                if(n2 + n3 > nt) {
                    r--;
                } else {
                    l++;
                }

                int sum = n1 + n2 + n3;
                int diff = Math.abs(sum - target);
                if(diff < min) {
                    min = diff;
                    res = sum;
                }
            }
        }

        return res;
    }
}
