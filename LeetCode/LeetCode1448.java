public class LeetCode1448 {
    public static int res;

    public static int goodNodes(TreeNode root) {
        res = 0;
        dfs(root, Integer.MIN_VALUE);
        return res;
    }

    public static void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            res++;
        }

        max = Math.max(max, node.val);

        dfs(node.left, max);
        dfs(node.right, max);
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
