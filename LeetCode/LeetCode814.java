public class LeetCode814 {
    public TreeNode pruneTree(TreeNode root) {
        boolean[] flag = new boolean[1];
        flag[0] = true;
        while (flag[0]) {
            flag[0] = false;
            if (root != null && root.left == null && root.right == null && root.val == 0) {
                return null;
            }

            helper(root, null, flag);
        }
        return root;
    }

    public void helper(TreeNode node, TreeNode prev, boolean[] flag) {
        if (node == null) {
            return;
        }

        helper(node.left, node, flag);
        helper(node.right, node, flag);

        if (node.left == null && node.right == null && node.val == 0) {
            if (prev != null) {
                if (prev.left == node) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
                flag[0] = true;
            }
        }
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
