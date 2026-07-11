public class LeetCode3754 {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }

        long sum = 0;
        long num = 0;

        while (n > 0) {
            int digit = n % 10;
            if (digit != 0) {
                sum += digit;
                num = num * 10 + digit;
            }
            n /= 10;
        }

        long x = 0;
        while (num > 0) {
            x = x * 10 + (num % 10);
            num /= 10;
        }

        return x * sum;
    }
}