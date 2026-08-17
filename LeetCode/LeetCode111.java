import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode111 {
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            depth++;
            for (int i = 0; i < level; i++) {
                TreeNode node = q.poll();

                if (node.left != null && node.right != null) {
                    return depth;
                }

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);
        t.right.right = new TreeNode(4);
        t.right.left = new TreeNode(5);
        System.out.println(minDepth(t));
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

        public TreeNode getLeft() {
            return left;
        }

        public TreeNode getRight() {
            return right;
        }
    }
}
