public class LeetCode267 {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(isPerfectSquare(n));
    }

    public static boolean isPerfectSquare(int n) {
        if (n == 1) return true;
        int l = 1;
        int r = n / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long sq = (long) mid * mid;

            if (sq == n) {
                return true;
            }
            if (sq > n) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
