public class LeetCode3345 {
    public int smallestNumber(int n, int t) {
        for (int i = n; i < n + 10; i++) {
            int prod = digProd(i);
            if (prod % t == 0) {
                return i;
            }
        }
        return n;
    }

    public int digProd(int n) {
        int p = 1;
        while (n > 0) {
            p *= (n % 10);
            n /= 10;
        }
        return p;
    }
}
