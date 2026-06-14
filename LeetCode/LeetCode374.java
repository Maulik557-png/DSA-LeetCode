public class LeetCode374 {
    private static int max = 10;

    public static void main(String[] args) {
        System.out.println(guessNumber(max));
    }

    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // public static int guessNumber(int n) {
    //     int l = 1;
    //     int r = n;
    //     int mid = l + (r - l) / 2;
    //     while (guess(mid) != 0) {
    //         mid = l + (r - l) / 2;
    //         if (guess(mid) == 0) {
    //             return mid;
    //         } else if (guess(mid) == -1) {
    //             r = mid - 1;
    //         } else {
    //             l = mid + 1;
    //         }
    //     }
    //     return mid;
    // }

    public static int guess(int num) {
        if (num > max) {
            return -1;
        } else if (num < max) {
            return 1;
        } else {
            return 0;
        }
    }
}
