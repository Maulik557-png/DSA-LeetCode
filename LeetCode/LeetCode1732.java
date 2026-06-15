public class LeetCode1732 {
    public static void main(String[] args) {
        int[] gain = { -4, -3, -2, -1, 4, 3, 2 };
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int prefix = 0;
        int res = 0;
        for (int n : gain) {
            prefix += n;
            res = Math.max(res, prefix);
        }
        return res;
    }
}
