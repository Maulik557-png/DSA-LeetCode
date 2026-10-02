import java.util.ArrayList;
import java.util.List;

public class Oct02P22 {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        ans.clear();
        StringBuilder s = new StringBuilder(2 * n);
        backtrack(s, 0, 0, n);
        return ans;
    }

    public void backtrack(StringBuilder s, int open, int close, int n) {
        if (s.length() == 2 * n) {
            ans.add(s.toString());
            return;
        }

        if (open < n) {
            s.append('(');
            backtrack(s, open + 1, close, n);
            s.deleteCharAt(s.length() - 1);
        }

        if (close < open) {
            s.append(')');
            backtrack(s, open, close + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
