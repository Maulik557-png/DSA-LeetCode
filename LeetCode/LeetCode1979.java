public class LeetCode1979 {
    public int findGCD(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MAX_VALUE;
        for (int n : nums) {
            a = Math.max(a, n);
            b = Math.min(b, n);
        }

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
