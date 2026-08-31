public class LeetCode2091 {
    public static int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxi = 0;
        int mini = 0;

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > max) {
                max = Math.max(max, n);
                maxi = i;
            }

            if (n < min) {
                min = Math.min(min, n);
                mini = i;
            }
        }

        int low = Math.min(maxi, mini);
        int high = Math.max(maxi, mini);

        int front = high + 1;
        int back = nums.length - low;
        int alt = low + 1 + (nums.length - high);

        return Math.min(Math.min(front, back), alt);
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions(new int[] {-14,61,29,-18,59,13,-67,-16,55,-57,7,74 }));
    }
}
