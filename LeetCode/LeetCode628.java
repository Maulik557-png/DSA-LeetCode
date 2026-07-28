public class LeetCode628 {
    public int maximumProduct(int[] nums) {
        int p1 = Integer.MIN_VALUE;
        int p2 = Integer.MIN_VALUE;
        int p3 = Integer.MIN_VALUE;
        int n1 = Integer.MAX_VALUE;
        int n2 = Integer.MAX_VALUE;

        for (int n : nums) {
            if (n > p1) {
                p3 = p2;
                p2 = p1;
                p1 = n;
            } else if (n > p2) {
                p3 = p2;
                p2 = n;
            } else if (n > p3) {
                p3 = n;
            }

            if (n < n1) {
                n2 = n1;
                n1 = n;
            } else if (n < n2) {
                n2 = n;
            }
        }

        return Math.max(p1 * p2 * p3, n1 * n2 * p1);
    }
}
