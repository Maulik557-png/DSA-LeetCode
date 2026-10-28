import java.util.Arrays;

public class LeetCode4091 {
    public long countMagicalPairs(String s) {
        int n = s.length();
        int width = 27;

        int right[] = new int[n * width];

        int[] next = new int[width - 1];
        Arrays.fill(next, n);

        int[] pos = new int[width - 1];

        for (int i = n - 1; i >= 0; i--) {
            next[s.charAt(i) - 'a'] = i;

            int m = 0;
            for (int p : next) {
                if (p < n) {
                    pos[m++] = p;
                }
            }

            Arrays.sort(pos, 0, m);

            int base = i * width;

            for (int d = 1; d < m; d++) {
                right[base + d] = pos[d] - pos[d - 1];
            }

            right[base + m] = n - pos[m - 1];
        }

        int[] last = new int[width - 1];
        Arrays.fill(last, -1);

        int[] lpos = new int[width - 1];
        long res = 0;

        for (int j = 0; j < n - 1; j++) {
            last[s.charAt(j) - 'a'] = j;

            int m = 0;
            for (int p : last) {
                if (p >= 0) {
                    lpos[m++] = p;
                }
            }

            Arrays.sort(lpos, 0, m);

            int base = (j + 1) * width;

            for (int d = 1; d < m; d++) {
                int l = lpos[m - d] - lpos[m - d - 1];
                res += (long) l * right[base + d];
            }

            int l = lpos[0] + 1;
            res += (long) l * right[base + m];
        }

        return res;
    }
}
