import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Sep25P1096 {
    public List<String> braceExpansionII(String expression) {
        Set<String> res = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(expression);

        while (!q.isEmpty()) {
            String curr = q.poll();
            int right = curr.indexOf('}');

            if (right == -1) {
                res.add(curr);
                continue;
            }

            int left = curr.lastIndexOf('{', right);
            String prefix = curr.substring(0, left);
            String suffix = curr.substring(right + 1);
            String[] options = curr.substring(left + 1, right).split(",");

            for (String op : options) {
                StringBuilder nextExpr = new StringBuilder();
                nextExpr.append(prefix).append(op).append(suffix);
                q.offer(nextExpr.toString());
            }
        }

        return new ArrayList<>(res);
    }
}
