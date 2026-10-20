import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oct20P3886 {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }

        int res = 0;
        for (int k : list) {
            boolean flag = true;
            for (int s = 0; s < n && flag; s += k) {
                int desc = 0, pos = -1;
                for (int j = 0; j < k; j++) {
                    int a = nums[s + j];
                    int b = nums[s + (j + 1) % k];
                    if (a > b) {
                        desc++;
                        pos = j;
                        if (desc > 1)
                            break;
                    }
                }

                if (desc > 1) {
                    flag = false;
                    break;
                }

                int r = (desc == 0) ? 0 : (pos + 1) % k;
                for (int j = 0; j < k; j++) {
                    if (nums[s + (r + j) % k] != sorted[s + j]) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag)
                res += k;
        }

        return res;
    }
}
