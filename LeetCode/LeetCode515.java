import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LeetCode515 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < level; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                max = Math.max(max, node.val);
            }
            res.add(max);
        }
        return res;
    }

    public List<Integer> largestValuess(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res, int depth) {
        if (node == null) {
            return;
        }

        if (depth == res.size()) {
            res.add(node.val);
        } else {
            res.set(depth, Math.max(res.get(depth), node.val));
        }

        dfs(node.left, res, depth + 1);
        dfs(node.right, res, depth + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
}
