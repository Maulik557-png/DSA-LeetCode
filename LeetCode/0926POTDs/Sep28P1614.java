public class Sep28P1614 {
    public int maxDepth(String s) {
        int res = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                max++;
            } else if (ch == ')') {
                res = Math.max(max, res);
                max--;
            }
        }

        return res;
    }
}
