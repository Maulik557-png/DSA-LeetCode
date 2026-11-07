public class LeetCode4095 {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int res = 0;
        int[] freq = new int[100001];
        int[] rank = new int[100001];
        int[] seen = new int[100001];

        for (int i = 0; i < n; i++) {
            int d = 0;
            int b = 0;

            for (int j = i; j < n; j++) {
                int x = nums[j];

                if (seen[x] != i + 1) {
                    seen[x] = i + 1;
                    rank[x] = ++d;
                    freq[x] = 1;
                    if (d != 1) {
                        b++;
                    }
                } else {
                    int r = rank[x];
                    int old = freq[x];

                    if (old != r) {
                        b--;
                    }
                    freq[x] = old + 1;

                    if (freq[x] > r) {
                        break;
                    }
                    if (freq[x] != r) {
                        b++;
                    }
                }

                if ((long) d * (d + 1) / 2 > n - i) {
                    break;
                }

                if (b == 0) {
                    res++;
                }
            }
        }

        return res;
    }
}
