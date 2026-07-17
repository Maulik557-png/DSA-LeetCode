public class LeetCode3658 {
    // public static int gcdOfOddEvenSums(int n) {
    //     return n;
    // }

    public static int gcdOfOddEvenSums(int n) {
        int os = n * n;
        int es = n * (n + 1);

        int n1 = es;
        int n2 = os;
        while (n2 != 0) {
            int r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }
}
