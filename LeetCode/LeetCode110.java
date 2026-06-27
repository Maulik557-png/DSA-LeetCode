public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = height(node.left);
        if (left == -1) {
            return -1;
        }

        int right = height(node.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }

    // public boolean isBalanced(TreeNode node) {
    //     if (node == null) {
    //         return true;
    //     }

    //     int leftDepth = maxDepth(node.left);
    //     int rightDepth = maxDepth(node.right);

    //     if (Math.abs(leftDepth - rightDepth) > 1) {
    //         return false;
    //     }

    //     boolean left = isBalanced(node.left);
    //     boolean right = isBalanced(node.right);

    //     if (!left || !right) {
    //         return false;
    //     }

    //     return true;
    // }

    // public static int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }

    //     int left = maxDepth(root.left);
    //     int right = maxDepth(root.right);

    //     return 1 + Math.max(left, right);
    // }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
