public class LeetCode543 {
    public static int[] d = new int[1];

    public static int diameterOfBinaryTree(TreeNode root) {
        d[0] = 0;
        maxDepth(root);
        return d[0];
    }

    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        d[0] = Math.max(d[0], left + right);
        return 1 + Math.max(left, right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
