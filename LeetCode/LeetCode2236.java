public class LeetCode2236 {
    public boolean checkTree(TreeNode root) {
        return (root.left.val + root.right.val) == root.val;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public int getVal() {
            return val;
        }
    }
}
