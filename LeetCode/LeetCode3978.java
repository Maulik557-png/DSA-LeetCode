public class LeetCode3978 {
    public boolean isMiddleElementUnique(int[] nums) {
        int l = nums.length;
        int mid = nums[l/2];
        int count = 0;

        for(int n: nums) {
            if(n == mid) {
                count++;
            }
        }

        return count == 1;
    }   
}
