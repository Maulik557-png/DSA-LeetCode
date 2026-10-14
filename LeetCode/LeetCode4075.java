import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode4075 {
    public List<Integer> maxPrimes(int n, int s) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        if (n >= 1) {
            isPrime[1] = false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        long sum = 0;

        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                if (sum + p > s) {
                    break;
                }

                res.add(p);
                sum += p;
            }
        }

        return res;
    }
}
