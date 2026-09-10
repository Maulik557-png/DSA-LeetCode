import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        int d = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (d == depth - 1) {
                    TreeNode node = queue.poll();
                    TreeNode l = node.left;
                    TreeNode r = node.right;

                    node.left = new TreeNode(val);
                    node.left.left = l;

                    node.right = new TreeNode(val);
                    node.right.right = r;
                } else {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }

            if (d == depth - 1) {
                break;
            }
            d++;
        }

        return root;
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
