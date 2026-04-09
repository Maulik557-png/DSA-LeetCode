public class LeetCode930 {

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int g = 2;
        System.out.println(numSubarraysWithSum(nums, g));
    }

    // This approch is good..
    // public static int numSubarraysWithSum(int[] nums, int goal) {
    //     Map<Integer, Integer> map = new HashMap<>();
    //     int res = 0;
    //     int curr = 0;
    //     map.put(0,1);
    //     for(int n: nums) {
    //         curr += n;
    //         res += map.getOrDefault(curr - goal, 0);
    //         map.put(curr, map.getOrDefault(curr, 0) + 1);
    //     }
    //     return res;
    // }

    // BUT.. This aproch is the Best
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return find(nums, goal) - find(nums, goal - 1);
    }

    public static int find(int[] nums, int goal) {
        if(goal < 0) return 0;

        int l = 0;
        int r = 0;
        int window = 0;
        int res = 0;

        for (; r < nums.length; r++) {
            window += nums[r];
            while (window > goal) {
                window -= nums[l];
                l++;
            }
            res += r - l + 1;
        }
        return res;
    }
}
