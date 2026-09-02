public class Apr8LeetCode3653 {
    private static final int MOD = 1_000_000_007;
    
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int[][] queries = {{0,2,1,4}};
        System.out.println(xorAfterQueries(nums, queries));
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] q: queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            for(int i = l; i <= r; i += k) nums[i] = (int) (((long)nums[i] * v) % MOD);
        }
        int res = 0;
        for(int n: nums) res ^= n;
        return res;
    }

    // public static int xorAfterQueries(int[] nums, int[][] queries) {
    //     for(int[] q: queries) {
    //         int idx = q[0];
    //         while(idx <= q[1]) {
    //             long curr = nums[idx];
    //             curr = (curr * q[3]) % MOD;
    //             nums[idx] = (int) curr;
    //             idx += q[2];
    //         }
    //     }
    //     int res = 0;
    //     for(int n: nums) {
    //         res = res ^ n;
    //     }
    //     return res;
    // }

    // public static int xorAfterQueries(int[] nums, int[][] queries) {
    //     for(int[] q: queries) {
    //         int idx = q[0];
    //         while(idx <= q[1]) {
    //             nums[idx] = (nums[idx] * q[3]) % (10^9 + 7);
    //             idx += q[2];
    //         }
    //     }
    //     int res = 0;
    //     for(int n: nums) {
    //         res = res ^ n;
    //     }
    //     return res;
    // }
}
