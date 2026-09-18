import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sep18P1520 {

    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] leftmost = new int[26];
        int[] rightmost = new int[26];
        Arrays.fill(leftmost, n);
        Arrays.fill(rightmost, -1);

        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';
            leftmost[charIdx] = Math.min(leftmost[charIdx], i);
            rightmost[charIdx] = i;
        }

        List<String> result = new ArrayList<>();
        int prevRight = -1;

        for (int i = 0; i < n; i++) {
            int charIdx = s.charAt(i) - 'a';

            if (i == leftmost[charIdx]) {
                int newRight = checkAndExpand(s, i, leftmost, rightmost);

                if (newRight != -1) {
                    if (i <= prevRight && !result.isEmpty()) {
                        result.set(result.size() - 1, s.substring(i, newRight + 1));
                    } else {
                        result.add(s.substring(i, newRight + 1));
                    }
                    prevRight = newRight;
                }
            }
        }
        return result;
    }

    private int checkAndExpand(String s, int start, int[] leftmost, int[] rightmost) {
        int right = rightmost[s.charAt(start) - 'a'];

        for (int j = start; j <= right; j++) {
            int charIdx = s.charAt(j) - 'a';

            if (leftmost[charIdx] < start) {
                return -1;
            }
            right = Math.max(right, rightmost[charIdx]);
        }
        return right;
    }
}
