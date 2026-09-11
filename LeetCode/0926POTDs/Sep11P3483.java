import java.util.HashMap;
import java.util.Map;

public class Sep11P3483 {
    public static int totalNumbers(int[] digits) {
        int[] nums = new int[450];
        int num = 100;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = num;
            num += 2;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : digits) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int res = 0;
        for (int n : nums) {
            Map<Integer, Integer> temp = new HashMap<>(map);
            int t = n;
            boolean failed = false;
            while (t > 0) {
                int dig = t % 10;
                t /= 10;

                if (!temp.containsKey(dig)) {
                    failed = true;
                    break;
                } else {
                    if (temp.get(dig) <= 0) {
                        failed = true;
                        break;
                    } else {
                        temp.put(dig, temp.get(dig) - 1);
                    }
                }
            }

            if (!failed) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(totalNumbers(new int[] { 3, 4, 3, 5, 6, 9, 1, 2, 8, 5, 3, 5, 0, 2, 0, 7 }));
    }
}
