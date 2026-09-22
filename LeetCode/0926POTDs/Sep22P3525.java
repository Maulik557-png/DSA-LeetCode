public class Sep22P3525 {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int qLen = queries.length;
        int[] res = new int[qLen];
        int n = nums.length;

        int[] prefixProd = new int[n];
        int curr = 1;
        for (int i = 0; i < n; i++) {
            curr = (curr * (nums[i] % k)) % k;
            prefixProd[i] = curr;
        }

        for (int q = 0; q < qLen; q++) {
            int idx = queries[q][0];
            int val = queries[q][1];
            int st = queries[q][2];
            int x = queries[q][3];

            nums[idx] = val;

            int running = (idx == 0) ? 1 : prefixProd[idx - 1];
            for (int i = idx; i < n; i++) {
                running = (running * (nums[i] % k)) % k;
                prefixProd[i] = running;
            }

            int count = 0;
            int base = 1;

            for (int j = st; j < n; j++) {
                base = (base * (nums[j] % k)) % k;
                if (base == x) {
                    count++;
                }
            }
            res[q] = count;
        }

        return res;
    }
}
