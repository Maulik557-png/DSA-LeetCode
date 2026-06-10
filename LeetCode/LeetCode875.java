public class LeetCode875 {
    public static void main(String[] args) {
        int[] piles = { 1000000000 };
        int hrs = 2;
        System.out.println(minEatingSpeed(piles, hrs));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int n : piles) {
            max = Math.max(max, n);
        }
        if (h == piles.length) {
            return max;
        }

        int l = 1;
        int r = max;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isPossible(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static boolean isPossible(int[] piles, int speed, int h) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
            if (time > h) {
                return false;
            }
        }
        return true;
    }

    // TLE
    // public static int minEatingSpeed(int[] piles, int h) {
    //     int max = Integer.MIN_VALUE;
    //     for (int i = 0; i < piles.length; i++) {
    //         max = Math.max(max, piles[i]);
    //     }

    //     if (h == piles.length) {
    //         return max;
    //     }

    //     for (int i = 1; i <= max; i++) {
    //         if (timeTaken(piles, i) == h) {
    //             return i;
    //         }
    //     }
    //     return max;
    // }

    // public static int timeTaken(int[] piles, int count) {
    //     int time = 0;
    //     for (int i = 0; i < piles.length; i++) {
    //         time += (int) Math.ceil((float) piles[i] / count);
    //     }
    //     return time;
    // }
}
