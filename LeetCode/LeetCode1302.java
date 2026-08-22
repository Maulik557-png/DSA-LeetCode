import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode1302 {
    int maxDepth = 0;
    int sum = 0;

    public int deepestLeavesSumm(TreeNode root) {
        maxDepth = 0;
        sum = 0;

        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            maxDepth = depth;
            sum = node.val;
        } else if (depth == maxDepth) {
            sum += node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        int summ = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            summ = 0;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();
                summ += node.val;
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return summ;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }
}
