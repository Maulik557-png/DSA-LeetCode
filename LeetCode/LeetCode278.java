public class LeetCode278 {
    private static int badVersion = 4;

    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }

    public static int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(!isBadVersion(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void setBadVersion(int version) {
        badVersion = version;
    }

    private static boolean isBadVersion(int mid) {
        return mid >= badVersion;
    }
}
