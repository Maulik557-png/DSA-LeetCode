public class LeetCode1394 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1, 3, 5, 5, 7 };
        System.out.println(findLucky(nums));
    }

    public static int findLucky(int[] nums) {
        int[] freq = new int[501];
        int lucky = -1;
        for (int n : nums) freq[n]++;
        for (int n : nums) if (freq[n] == n) lucky = Math.max(lucky, n);
        return lucky;
    }

    // public static int findLucky(int[] nums) {
    // int[] freq = new int[501];
    // for (int n : nums) freq[n]++;
    // for (int i = 500; i >= 1; i--) {
    // if (freq[i] == 0) continue;
    // else if (freq[i] == i) return i;
    // }
    // return -1;
    // }

}
