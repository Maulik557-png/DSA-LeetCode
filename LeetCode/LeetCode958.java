import java.util.LinkedList;
import java.util.Queue;

public class LeetCode958 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(new LeetCode958().isCompleteTree(root));
    }

    boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean foundNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                foundNull = true;
            } else {
                if (foundNull) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return true;
    }

    static class TreeNode {
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
