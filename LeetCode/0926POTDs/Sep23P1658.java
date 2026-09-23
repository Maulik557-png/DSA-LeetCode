public class Sep23P1658 {
    public int minOperations(int[] nums, int x) {
        if (nums[0] > x && nums[nums.length - 1] > x) {
            return -1;
        } else if (nums[0] == x || nums[nums.length - 1] == x) {
            return 1;
        } else {
            int sum = 0;
            for (int i : nums) {
                sum += i;
            }
            if (sum < x) {
                return -1;
            } else if (sum == x) {
                return nums.length;
            } else {
                int target = sum - x;
                int curr = 0;
                int maxLen = -1;
                int l = 0;

                for (int r = 0; r < nums.length; r++) {
                    curr += nums[r];

                    while (curr > target && l <= r) {
                        curr -= nums[l];
                        l++;
                    }

                    if (curr == target) {
                        maxLen = Math.max(maxLen, r - l + 1);
                    }
                }
                return maxLen == -1 ? -1 : nums.length - maxLen;
            }
        }
    }
}
