import java.util.HashMap;
import java.util.Map;

public class LeetCode4036 {
    public String[] largestString(int[] nums) {
        char ch = 'a';
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            map.put(i, ch);
            ch++;
        }

        String[] res = new String[nums.length];
        int i = 0;

        for (int n : nums) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int hb = Integer.highestOneBit(n);
                int pow = Integer.numberOfTrailingZeros(hb);

                if (pow == 26) {
                    sb.append("zz");
                } else {
                    sb.append(map.get(pow));
                }

                n -= hb;
            }
            res[i++] = sb.toString();
        }

        return res;
    }
}
