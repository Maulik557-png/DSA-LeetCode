public class LeetCode1101 {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        int days = 3;
        System.out.println(shipWithinDays(weights, days));
    }

    public static int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int n : weights) {
            max = Math.max(max, n);
            sum += n;
        }

        int l = max;
        int r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(weights, mid, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean isPossible(int[] weights, int capacity, int days) {
        int d = 0;
        int i = 0;
        while (i < weights.length) {
            int c = capacity;
            while (i < weights.length && weights[i] <= c) {
                c -= weights[i++];
            }
            d++;
        }
        return d <= days;
    }
}
