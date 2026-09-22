import java.util.Arrays;

public class LeetCode4056 {
    public int countIntersectingIntervals(int[][] intervals) {
        int res = 0;
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < n; i++) {
            int curr = intervals[i][1];
            for (int j = i + 1; j < n; j++) {
                if (intervals[j][0] <= curr) {
                    res++;
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
