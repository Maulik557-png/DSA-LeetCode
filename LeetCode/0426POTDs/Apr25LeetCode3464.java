import java.util.*;

public class Apr25LeetCode3464 {
    public static void main(String[] args) {
        int side = 2;
        int k = 4;
        int[][] points = { { 0, 2 }, { 2, 0 }, { 2, 2 }, { 0, 0 } };
        System.out.println(maxDistance(side, points, k));
    }

    public static int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            long p;
            if (y == 0)
                p = x;
            else if (x == side)
                p = (long) side + y;
            else if (y == side)
                p = 2L * side + (side - x);
            else // x == 0
                p = 3L * side + (side - y);
            pos[i] = p;
        }
        Arrays.sort(pos);
        long L = 4L * side;
        int total = n * 2;
        long[] ext = new long[total];
        for (int i = 0; i < n; i++){
            ext[i] = pos[i];
            ext[i+n] = pos[i] + L;
        }
        
        long low = 0, high = 2L * side;
        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (canPlace(mid, k, n, ext, L))
                low = mid;
            else
                high = mid - 1;
        }
        return (int) low;
    }
    
    private static boolean canPlace(long d, int k, int n, long[] ext, long L) {
        for (int start = 0; start < n; start++) {
            int cur = start;
            long last = ext[start];
            boolean valid = true;
            int limit = start + n;
            for (int step = 1; step < k; step++){
                long target = last + d;
                int lo = cur + 1, hi = limit;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if (ext[mid] < target)
                        lo = mid + 1;
                    else
                        hi = mid;
                }
                if (lo == limit) {
                    valid = false;
                    break;
                }
                cur = lo;
                last = ext[cur];
            }
            if (valid && ext[start] + L - last >= d)
                return true;
        }
        return false;
    }

    // public static int maxDistance(int side, int[][] points, int k) {
    //     int n = points.length;
    //     long[] pos = new long[n];

    //     // Convert to 1D
    //     for (int i = 0; i < n; i++) {
    //         int x = points[i][0];
    //         int y = points[i][1];

    //         if (y == 0)
    //             pos[i] = x;
    //         else if (x == side)
    //             pos[i] = side + y;
    //         else if (y == side)
    //             pos[i] = 2L * side + (side - x);
    //         else
    //             pos[i] = 3L * side + (side - y);
    //     }

    //     Arrays.sort(pos);

    //     long perimeter = 4L * side;

    //     // Build extended array
    //     long[] ext = new long[2 * n];
    //     for (int i = 0; i < n; i++) {
    //         ext[i] = pos[i];
    //         ext[i + n] = pos[i] + perimeter;
    //     }

    //     long low = 0, high = perimeter, ans = 0;

    //     while (low <= high) {
    //         long mid = (low + high) / 2;

    //         if (canPlace(ext, n, k, mid, perimeter)) {
    //             ans = mid;
    //             low = mid + 1;
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return (int) ans;
    // }

    // private static boolean canPlace(long[] ext, int n, int k, long d, long perimeter) {
    //     int m = ext.length;

    //     // Precompute next jumps using binary search
    //     int[] next = new int[m];

    //     for (int i = 0; i < m; i++) {
    //         long target = ext[i] + d;
    //         int j = Arrays.binarySearch(ext, target);

    //         if (j < 0)
    //             j = -j - 1; // first >= target
    //         next[i] = j;
    //     }

    //     // Try each starting point
    //     for (int i = 0; i < n; i++) {
    //         int count = 1;
    //         int curr = i;

    //         while (count < k) {
    //             curr = next[curr];
    //             if (curr >= i + n)
    //                 break; // out of window
    //             count++;
    //         }

    //         if (count == k) {
    //             long first = ext[i];
    //             long last = ext[curr];

    //             if ((first + perimeter) - last >= d) {
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;
    // }

    // TLE
    // public static int maxDistance(int side, int[][] points, int k) {
    //     int n = points.length;

    //     // Step 1: Convert 2D boundary points → 1D positions
    //     long[] pos = new long[n];
    //     for (int i = 0; i < n; i++) {
    //         int x = points[i][0];
    //         int y = points[i][1];

    //         if (y == 0) {
    //             pos[i] = x; // bottom
    //         } else if (x == side) {
    //             pos[i] = side + y; // right
    //         } else if (y == side) {
    //             pos[i] = 2L * side + (side - x); // top
    //         } else {
    //             pos[i] = 3L * side + (side - y); // left
    //         }
    //     }

    //     Arrays.sort(pos);

    //     // Step 2: Binary search on answer
    //     long low = 0, high = 4L * side, ans = 0;

    //     while (low <= high) {
    //         long mid = (low + high) / 2;

    //         if (canPlace(pos, k, mid, 4L * side)) {
    //             ans = mid;
    //             low = mid + 1; // try bigger distance
    //         } else {
    //             high = mid - 1;
    //         }
    //     }

    //     return (int) ans;
    // }

    // // Step 3: Check if we can pick k points with min distance >= d
    // private static boolean canPlace(long[] pos, int k, long d, long perimeter) {
    //     int n = pos.length;

    //     // Try each point as starting point (circular handling)
    //     for (int i = 0; i < n; i++) {
    //         int count = 1;
    //         long last = pos[i];

    //         for (int j = i + 1; j < n; j++) {
    //             if (pos[j] - last >= d) {
    //                 count++;
    //                 last = pos[j];
    //             }
    //             if (count == k)
    //                 break;
    //         }

    //         if (count < k)
    //             continue;

    //         // Check circular condition (last <-> first)
    //         long wrapDistance = (pos[i] + perimeter) - last;
    //         if (wrapDistance >= d)
    //             return true;
    //     }

    //     return false;
    // }
}
