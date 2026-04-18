public class LeetCode3783 {
    public static void main(String[] args) {
        int n = 325;
        System.out.println(mirrorDistance(n));
    }

    public static int mirrorDistance(int n) {
        int num = n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return Math.abs(num - rev);
    }

    // public static int mirrorDistance(int n) {
    //     return Math.abs(n - reverse(n));
    // }

    // private static int reverse(int n) {
    //     int div = 10;
    //     int rev = 0;
    //     while (n > 0) {
    //         rev = rev * div + n % div;
    //         n /= 10;
    //     }
    //     return rev;
    // }
}
