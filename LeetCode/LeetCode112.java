public class LeetCode112 {
    int sum;
    boolean res = false;

    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (isLeaf(root)) {
            return root.val == target;
        }

        helper(root, target);
        return res;
    }

    public void helper(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        sum += root.val;

        if (isLeaf(root) && sum == target) {
            res = true;
            return;
        }

        helper(root.left, target);
        helper(root.right, target);

        sum -= root.val;
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
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
