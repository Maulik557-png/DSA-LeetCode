public class LeetCode219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;

        System.out.println(containsNearbyDuplicate(nums, k));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        boolean res = false;

        while(l < r)    {
            if(Math.abs(l - r) <= k && nums[l] == nums[r])  res = true;
            l++;
            r--;
        }   
        return res;
    }
}
