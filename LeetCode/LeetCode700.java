public class LeetCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (node.val == val) {
                return node;
            }

            if (val > node.val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        return null;
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
