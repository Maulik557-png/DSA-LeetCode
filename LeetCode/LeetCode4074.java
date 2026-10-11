public class LeetCode4074 {
    public boolean threeFibonacciSum(int n) {
        int a = 0;
        int b = 1;

        while (a + b <= n) {
            int c = a + b;

            if (a + b + c == n) {
                return true;
            }

            a = b;
            b = c;
        }

        return false;
    }
}
