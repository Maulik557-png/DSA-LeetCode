public class Sep07P3870 {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        } else {
            return n - 999;
        }
    }

    public int countCommass(int n) {
        return Math.max(0, n - 999);
    }
}
