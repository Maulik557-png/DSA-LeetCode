public class LeetCode3622 {
    public boolean checkDivisibility(int n) {
        int num = n;
        int digSum = 0;
        int digProd = 1;
        while (num > 0) {
            int digit = num % 10;
            digSum += digit;
            digProd *= digit;
            num /= 10;
        }

        return n % (digSum + digProd) == 0;
    }
}
