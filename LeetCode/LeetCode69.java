public class LeetCode69 {
    public static void main(String[] args) {
        int x = 4;
        System.out.println(mySqrt(x));    
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;
        int left = 1;
        int right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            }

            if (square < x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}
