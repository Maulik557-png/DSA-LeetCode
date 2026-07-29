public class LeetCode1464 {
    public int maxProduct(int[] nums) {
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n > n1) {
                n2 = n1;
                n1 = n;
            } else if (n > n2) {
                n2 = n;
            }
        }

        return (n1 - 1) * (n2 - 1);
    }
}
